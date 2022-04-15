package com.example.demo.dto

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "Student")
@XmlAccessorType(XmlAccessType.FIELD)
data class XmlRequest(
    @XmlElement(name = "name") val name: String = "",
    @XmlElement(name = "surname") val surname: String="",
    @XmlElement(name = "age") val age: Double = 0.0,
    @XmlElement(name = "birthdate") val birthdate: String = ""
) {
    override fun toString(): String {
        return "<Student>\n" +
                "    <name>${name}<name>\n" +
                "    <surname>${surname}<surname>\n" +
                "    <age>${age}<age>\n" +
                "    <birthdate>${birthdate}<birthdate>\n" +
                "<Student>"
    }
}