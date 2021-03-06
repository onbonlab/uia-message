/*******************************************************************************
 * Copyright 2017 UIA
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package uia.message;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import uia.message.codec.BitCodec;
import uia.message.codec.BlockCodec;
import uia.message.codec.BlockCodecException;
import uia.message.codec.BooleanCodec;
import uia.message.codec.ByteArrayCodec;
import uia.message.codec.ByteCodec;
import uia.message.codec.ColorCodec;
import uia.message.codec.DateTimeCodec;
import uia.message.codec.DateTimeStringCodec;
import uia.message.codec.DoubleCodec;
import uia.message.codec.IntegerBCDCodec;
import uia.message.codec.IntegerBCDLSBCodec;
import uia.message.codec.IntegerCodec;
import uia.message.codec.IntegerLSBCodec;
import uia.message.codec.IntegerStringCodec;
import uia.message.codec.LongCodec;
import uia.message.codec.StringCodec;
import uia.message.fx.ValueFx;
import uia.message.model.xml.BlockBaseType;
import uia.message.model.xml.BlockCodecType;
import uia.message.model.xml.DataExType;
import uia.message.model.xml.FxType;
import uia.message.model.xml.MessageType;

/**
 * DataEx factory. This factory can serialize and deserialize message depending on definition in XML.
 *
 *
 * @author Kyle
 */
public class DataExFactory {

    private static HashMap<String, DataExFactory> DATA_EX_FACTORY;

    private final DataExType dataEx;

    private HashMap<String, BlockBaseType> bodySpace;

    private HashMap<String, MessageType> messageSpace;

    private HashMap<String, BlockCodec<?>> codecSpace;

    private HashMap<String, ValueFx> fxSpace;

    private final ArrayList<BlockListener> listeners;

    static {
        DATA_EX_FACTORY = new HashMap<String, DataExFactory>();
    }

    /**
     * Register a XML with a specific domain name.
     *
     * @param domain Domain name.
     * @param fileName XML file name.
     * @throws Exception Raise when file is wrong.
     */
    public static void register(String domain, String fileName) throws Exception {
        register(domain, new File(fileName));
    }

    /**
     * Register a XML with a specific domain name.
     *
     * @param domain Domain name.
     * @param stream XML file stream.
     * @throws Exception Raise when file is wrong.
     */
    public static void register(String domain, InputStream stream) throws Exception {
        if (!DATA_EX_FACTORY.containsKey(domain)) {
            DATA_EX_FACTORY.put(domain, new DataExFactory(DataExCodec.decode(stream)));
        }
    }

    /**
     * Register a XML with a specific domain name.
     *
     * @param domain Domain name.
     * @param file XML file.
     * @throws Exception Raise when file is wrong.
     */
    public static void register(String domain, File file) throws Exception {
        if (!DATA_EX_FACTORY.containsKey(domain)) {
            DATA_EX_FACTORY.put(domain, new DataExFactory(DataExCodec.decode(file)));
        }
    }

    /**
     * Register a XML with a specific domain name.
     *
     * @param domain Domain name.
     * @param xmlContent XML content.
     * @throws Exception Raise when file is wrong.
     */
    public static void registerContent(String domain, String xmlContent) throws Exception {
        register(domain, xmlContent);
    }

    /**
     * Get DataEx factory with specific domain name.
     *
     * @param domain The domain name.
     * @return The DataEx factory. Null if this domain is not registered.
     */
    public static DataExFactory getFactory(String domain) {
        return DATA_EX_FACTORY.get(domain);
    }

    private DataExFactory(DataExType dataEx) {
        this.dataEx = dataEx;
        this.listeners = new ArrayList<BlockListener>();
        loadBlockSpace();
        loadMessageSpace();
        loadCodecSpace();
        loadFxSpace();
    }

    /**
     * Get Fx names defined in FxSpace.
     *
     * @return Fx names.
     */
    public Set<String> getFxList() {
        return this.fxSpace.keySet();
    }

    /**
     * Get message names defined in SpaceSpace.
     *
     * @return Message names.
     */
    public Set<String> getMessageList() {
        return this.messageSpace.keySet();
    }

    /**
     * Get codec names defined in CodecSpace.
     *
     * @return Message names.
     */
    public Set<String> getCodecList() {
        return this.codecSpace.keySet();
    }

    /**
     * Add block listener.
     *
     * @param listener The listener.
     */
    public void addListener(BlockListener listener) {
        if (listener != null && !this.listeners.contains(listener)) {
            this.listeners.add(listener);
        }
    }

    /**
     * Remove block listener.
     *
     * @param listener The listener.
     */
    public void removeListener(BlockListener listener) {
        if (listener != null) {
            this.listeners.remove(listener);
        }
    }

    /**
     * Clear all block listeners.
     */
    public void clearListeners() {
        this.listeners.clear();
    }

    /**
     * Serialize object of message to byte array.
     *
     * @param domain The domain name.
     * @param messageName The message name defined in XML.
     * @param value Object of message.
     * @return Serialize result or null if no domain.
     * @throws BlockCodecException Raise when serialize failed.
     */
    public static byte[] serialize(String domain, String messageName, Object value) throws BlockCodecException {
        return serialize(domain, messageName, value, null);
    }

    /**
     * Serialize object of message to byte array.
     *
     * @param domain The domain name.
     * @param messageName The message name defined in XML.
     * @param value Object of message.
     * @param context Useful data to serialize message.
     * @return Serialize result or null if no domain.
     * @throws BlockCodecException Raise when serialize failed.
     */
    public static byte[] serialize(String domain, String messageName, Object value, Map<String, Object> context) throws BlockCodecException {
        DataExFactory factory = getFactory(domain);
        if (factory == null) {
            throw new BlockCodecException("Domain:" + domain + " doesn't exist.");
        }
        return factory.createSerializer(messageName).serialize(value, context);
    }

    /**
     * Deserialize byte array to object of message.
     *
     * @param domain The domain name.
     * @param messageName The message name defined in XML.
     * @param value byte array of message.
     * @param <T> Type returned.
     * @return Deserialize result or null if no domain.
     * @throws BlockCodecException Raise when deserialize failed.
     */
    public static <T> T deserialize(String domain, String messageName, byte[] value) throws BlockCodecException {
        return deserialize(domain, messageName, value, null);
    }

    /**
     * Deserialize byte array to object of message.
     *
     * @param domain The domain name.
     * @param messageName The message name defined in XML.
     * @param value byte array of message.
     * @param context Useful data to deserialize message.
     * @param <T> Type returned.
     * @return Deserialize result or null if no domain.
     * @throws BlockCodecException Raise when deserialize failed.
     */
    public static <T> T deserialize(String domain, String messageName, byte[] value, Map<String, Object> context) throws BlockCodecException {
        DataExFactory factory = getFactory(domain);
        if (factory == null) {
            throw new BlockCodecException("Domain:" + domain + " doesn't exist.");
        }
        return factory.createDeserializer(messageName).deserialize(value, context);
    }

    public void generateClass(String messageName, PrintStream out) throws BlockCodecException {
        MessageType mt = this.messageSpace.get(messageName);
        if (mt == null) {
            return;
        }
        new MessageClassGenerator(this, mt).generate(out);
    }

    /**
     * Serialize object of message to byte array.
     *
     * @param messageName The message name defined in XML.
     * @param value Object of message.
     * @return Serialize result.
     * @throws BlockCodecException Raise when serialize failed.
     */
    public byte[] serialize(String messageName, Object value) throws BlockCodecException {
        return createSerializer(messageName).serialize(value);
    }

    /**
     * Serialize object of message to byte array.
     *
     * @param messageName The message name defined in XML.
     * @param value Object of message.
     * @param context Useful data to serialize message.
     * @return Serialize result.
     * @throws BlockCodecException Raise when serialize failed.
     */
    public byte[] serialize(String messageName, Object value, Map<String, Object> context) throws BlockCodecException {
        return createSerializer(messageName).serialize(value, context);
    }

    /**
     * Deserialize byte array to object of message.
     *
     * @param messageName The message name defined in XML.
     * @param value byte array of message.
     * @param <T> Type returned.
     * @return Deserialize result.
     * @throws BlockCodecException Raise when deserialize failed.
     */
    public <T> T deserialize(String messageName, byte[] value) throws BlockCodecException {
        return createDeserializer(messageName).deserialize(value);
    }

    /**
     * Deserialize byte array to object of message.
     *
     * @param messageName The message name defined in XML.
     * @param value byte array of message.
     * @param context Useful data to deserialize message.
     * @param <T> Type returned.
     * @return Deserialize result.
     * @throws BlockCodecException Raise when deserialize failed.
     */
    public <T> T deserialize(String messageName, byte[] value, Map<String, Object> context) throws BlockCodecException {
        return createDeserializer(messageName).deserialize(value, context);
    }

    /**
     * Create a deserializer with specific message name.
     *
     * @param messageName The message name defined in XML.
     * @return The deserializer. Can be null.
     * @throws BlockCodecException Raise when serialize failed.
     */
    public MessageDeserializer createDeserializer(String messageName) throws BlockCodecException {
        MessageType mt = this.messageSpace.get(messageName);
        if (mt == null) {
            throw new BlockCodecException("Mesage:" + messageName + " doesn't exist.");
        }
        return new MessageDeserializer(this, mt);
    }

    /**
     * Create a serializer with specific message name.
     *
     * @param messageName The message name defined in XML.
     * @return The serializer. Can be null.
     * @throws BlockCodecException Raise when serialize failed.
     */
    public MessageSerializer createSerializer(String messageName) throws BlockCodecException {
        MessageType mt = this.messageSpace.get(messageName);
        if (mt == null) {
            throw new BlockCodecException("Mesage:" + messageName + " doesn't exist.");
        }
        return new MessageSerializer(this, mt);
    }

    BlockBaseType getReferenceBlock(String blockName) {
        return this.bodySpace.get(blockName);
    }

    ValueFx getFx(String name) throws BlockCodecException {
        ValueFx fx = this.fxSpace.get(name);
        if (fx == null) {
            throw new BlockCodecException("fx name failed. " + name + " is not defined.");
        }
        return fx;
    }

    BlockCodec<?> getCodec(String dataType) throws BlockCodecException {
        BlockCodec<?> decoder = this.codecSpace.get(dataType);
        if (decoder == null) {
            throw new BlockCodecException("codec type failed. " + dataType + " is not defined.");
        }
        return decoder;
    }

    private void loadBlockSpace() {
        this.bodySpace = new HashMap<String, BlockBaseType>();
        if (this.dataEx.getBlockSpace() == null) {
            return;
        }
        for (BlockBaseType block : this.dataEx.getBlockSpace().getBlockOrBlockListOrBlockSeq()) {
            this.bodySpace.put(block.getName(), block);
        }
    }

    private void loadMessageSpace() {
        this.messageSpace = new HashMap<String, MessageType>();
        for (MessageType mt : this.dataEx.getMessageSpace().getMessage()) {
            this.messageSpace.put(mt.getName(), mt);
        }
    }

    private void loadFxSpace() {
        this.fxSpace = new HashMap<String, ValueFx>();
        if (this.dataEx.getFxSpace() == null) {
            return;
        }
        for (FxType fx : this.dataEx.getFxSpace().getFx()) {
            try {
                this.fxSpace.put(
                        fx.getName(),
                        (ValueFx) Class.forName(fx.getDriver()).newInstance());
            }
            catch (Exception ex) {
            }
        }
    }

    private void loadCodecSpace() {
        this.codecSpace = new HashMap<String, BlockCodec<?>>();
        this.codecSpace.put("Bcd", new IntegerBCDCodec());
        this.codecSpace.put("BcdL", new IntegerBCDLSBCodec());
        this.codecSpace.put("Bit", new BitCodec());
        this.codecSpace.put("Boolean", new BooleanCodec());
        this.codecSpace.put("Byte", new ByteCodec());
        this.codecSpace.put("ByteArray", new ByteArrayCodec());
        this.codecSpace.put("Color", new ColorCodec());
        this.codecSpace.put("DateTime", new DateTimeCodec());
        this.codecSpace.put("DateTimeString", new DateTimeStringCodec());
        this.codecSpace.put("Double", new DoubleCodec());
        this.codecSpace.put("Float", new DoubleCodec());
        this.codecSpace.put("Int", new IntegerCodec(false));
        this.codecSpace.put("IntL", new IntegerLSBCodec(false));
        this.codecSpace.put("IntString", new IntegerStringCodec());
        this.codecSpace.put("Long", new LongCodec());
        this.codecSpace.put("String", new StringCodec());
        this.codecSpace.put("UInt", new IntegerCodec(true));
        this.codecSpace.put("UIntL", new IntegerLSBCodec(true));

        if (this.dataEx.getBlockCodecSpace() == null) {
            return;
        }
        for (BlockCodecType decoder : this.dataEx.getBlockCodecSpace().getBlockCodec()) {
            try {
                this.codecSpace.put(
                        decoder.getDataType(),
                        (BlockCodec<?>) Class.forName(decoder.getDriver()).newInstance());
            }
            catch (Exception ex) {
            }
        }
    }

    void valueHandled(String name, BlockInfo block) {
        for (BlockListener l : this.listeners) {
            l.valueHandled(name, block);
        }
    }

    void listTouched(String name, boolean begin, int offset) {
        for (BlockListener l : this.listeners) {
            l.listTouched(name, begin, offset);
        }
    }

    void seqTouched(String name, boolean begin, int offset) {
        for (BlockListener l : this.listeners) {
            l.seqTouched(name, begin, offset);
        }
    }
}
