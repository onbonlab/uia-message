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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataExType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataExType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BlockSpace" type="{http://message.uia/model/xml}BlockSpaceType"/>
 *         &lt;element name="MessageSpace" type="{http://message.uia/model/xml}MessageSpaceType"/>
 *         &lt;element name="BlockCodecSpace" type="{http://message.uia/model/xml}BlockCodecSpaceType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataExType", propOrder = {
    "blockSpace",
    "messageSpace",
    "blockCodecSpace"
})
public class DataExType {

    @XmlElement(name = "BlockSpace", required = true)
    protected BlockSpaceType blockSpace;
    @XmlElement(name = "MessageSpace", required = true)
    protected MessageSpaceType messageSpace;
    @XmlElement(name = "BlockCodecSpace", required = true)
    protected BlockCodecSpaceType blockCodecSpace;

    /**
     * Gets the value of the blockSpace property.
     * 
     * @return
     *     possible object is
     *     {@link BlockSpaceType }
     *     
     */
    public BlockSpaceType getBlockSpace() {
        return blockSpace;
    }

    /**
     * Sets the value of the blockSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link BlockSpaceType }
     *     
     */
    public void setBlockSpace(BlockSpaceType value) {
        this.blockSpace = value;
    }

    /**
     * Gets the value of the messageSpace property.
     * 
     * @return
     *     possible object is
     *     {@link MessageSpaceType }
     *     
     */
    public MessageSpaceType getMessageSpace() {
        return messageSpace;
    }

    /**
     * Sets the value of the messageSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageSpaceType }
     *     
     */
    public void setMessageSpace(MessageSpaceType value) {
        this.messageSpace = value;
    }

    /**
     * Gets the value of the blockCodecSpace property.
     * 
     * @return
     *     possible object is
     *     {@link BlockCodecSpaceType }
     *     
     */
    public BlockCodecSpaceType getBlockCodecSpace() {
        return blockCodecSpace;
    }

    /**
     * Sets the value of the blockCodecSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link BlockCodecSpaceType }
     *     
     */
    public void setBlockCodecSpace(BlockCodecSpaceType value) {
        this.blockCodecSpace = value;
    }

}
