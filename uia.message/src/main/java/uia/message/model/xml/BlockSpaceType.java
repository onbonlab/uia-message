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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BlockSpaceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BlockSpaceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="Block" type="{http://message.uia/model/xml}BitBlockType"/>
 *           &lt;element name="BlockList" type="{http://message.uia/model/xml}BitBlockListType"/>
 *           &lt;element name="BlockSeq" type="{http://message.uia/model/xml}BitBlockSeqType"/>
 *           &lt;element name="BlockSeqList" type="{http://message.uia/model/xml}BitBlockSeqListType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BlockSpaceType", propOrder = {
    "blockOrBlockListOrBlockSeq"
})
public class BlockSpaceType {

    @XmlElements({
        @XmlElement(name = "Block", type = BitBlockType.class),
        @XmlElement(name = "BlockList", type = BitBlockListType.class),
        @XmlElement(name = "BlockSeq", type = BitBlockSeqType.class),
        @XmlElement(name = "BlockSeqList", type = BitBlockSeqListType.class)
    })
    protected List<BlockBaseType> blockOrBlockListOrBlockSeq;

    /**
     * Gets the value of the blockOrBlockListOrBlockSeq property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the blockOrBlockListOrBlockSeq property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlockOrBlockListOrBlockSeq().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BitBlockType }
     * {@link BitBlockListType }
     * {@link BitBlockSeqType }
     * {@link BitBlockSeqListType }
     * 
     * 
     */
    public List<BlockBaseType> getBlockOrBlockListOrBlockSeq() {
        if (blockOrBlockListOrBlockSeq == null) {
            blockOrBlockListOrBlockSeq = new ArrayList<BlockBaseType>();
        }
        return this.blockOrBlockListOrBlockSeq;
    }

}
