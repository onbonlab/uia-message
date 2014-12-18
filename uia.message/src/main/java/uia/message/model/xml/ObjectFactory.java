/*******************************************************************************
 * * Copyright (c) 2014, UIA
 * * All rights reserved.
 * * Redistribution and use in source and binary forms, with or without
 * * modification, are permitted provided that the following conditions are met:
 * *
 * *     * Redistributions of source code must retain the above copyright
 * *       notice, this list of conditions and the following disclaimer.
 * *     * Redistributions in binary form must reproduce the above copyright
 * *       notice, this list of conditions and the following disclaimer in the
 * *       documentation and/or other materials provided with the distribution.
 * *     * Neither the name of the {company name} nor the
 * *       names of its contributors may be used to endorse or promote products
 * *       derived from this software without specific prior written permission.
 * *
 * * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS "AS IS" AND ANY
 * * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * * DISCLAIMED. IN NO EVENT SHALL THE REGENTS AND CONTRIBUTORS BE LIABLE FOR ANY
 * * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.25 at 05:31:46 PM CST 
//


package uia.message.model.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the uia.message.model.xml package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DataEx_QNAME = new QName("http://message.uia/model/xml", "DataEx");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: uia.message.model.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DataExType }
     * 
     */
    public DataExType createDataExType() {
        return new DataExType();
    }

    /**
     * Create an instance of {@link BitBlockRefType }
     * 
     */
    public BitBlockRefType createBitBlockRefType() {
        return new BitBlockRefType();
    }

    /**
     * Create an instance of {@link BlockCodecType }
     * 
     */
    public BlockCodecType createBlockCodecType() {
        return new BlockCodecType();
    }

    /**
     * Create an instance of {@link PropType }
     * 
     */
    public PropType createPropType() {
        return new PropType();
    }

    /**
     * Create an instance of {@link MessageSpaceType }
     * 
     */
    public MessageSpaceType createMessageSpaceType() {
        return new MessageSpaceType();
    }

    /**
     * Create an instance of {@link BlockCodecSpaceType }
     * 
     */
    public BlockCodecSpaceType createBlockCodecSpaceType() {
        return new BlockCodecSpaceType();
    }

    /**
     * Create an instance of {@link CodecPropSetType }
     * 
     */
    public CodecPropSetType createCodecPropSetType() {
        return new CodecPropSetType();
    }

    /**
     * Create an instance of {@link BitBlockType }
     * 
     */
    public BitBlockType createBitBlockType() {
        return new BitBlockType();
    }

    /**
     * Create an instance of {@link BitBlockSeqListType }
     * 
     */
    public BitBlockSeqListType createBitBlockSeqListType() {
        return new BitBlockSeqListType();
    }

    /**
     * Create an instance of {@link BlockSpaceType }
     * 
     */
    public BlockSpaceType createBlockSpaceType() {
        return new BlockSpaceType();
    }

    /**
     * Create an instance of {@link BitBlockSeqType }
     * 
     */
    public BitBlockSeqType createBitBlockSeqType() {
        return new BitBlockSeqType();
    }

    /**
     * Create an instance of {@link BitBlockListType }
     * 
     */
    public BitBlockListType createBitBlockListType() {
        return new BitBlockListType();
    }

    /**
     * Create an instance of {@link MessageType }
     * 
     */
    public MessageType createMessageType() {
        return new MessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataExType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://message.uia/model/xml", name = "DataEx")
    public JAXBElement<DataExType> createDataEx(DataExType value) {
        return new JAXBElement<DataExType>(_DataEx_QNAME, DataExType.class, null, value);
    }

}
