package com.example.demo.controller

import com.example.demo.dto.JsonResponse
import com.example.demo.dto.XmlRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.xml.bind.JAXBContext
import org.springframework.http.*
import java.io.StringWriter
import javax.xml.bind.Marshaller

@RestController
class XMLtoJSONController {
    @PostMapping("/getjson", consumes = [MediaType.APPLICATION_XML_VALUE],
                                produces = [MediaType.APPLICATION_JSON_VALUE])
    fun convert(@RequestBody xml:XmlRequest): JsonResponse? {
        try {
            val jaxbContext = JAXBContext.newInstance(XmlRequest::class.java)
            val unmarshaller = jaxbContext.createUnmarshaller()
            val jsonObj=JsonResponse(
                name = xml.name,
                surname = xml.surname,
                age = xml.age,
                birthdate = xml.birthdate
            )
            val xmlStr = xml.toString();
            println(xmlStr)
            xmlStr.reader().use { it ->
                {
                    val xmlObj = unmarshaller.unmarshal(it) as XmlRequest
                    println(xmlObj.name)
                    println(xmlObj.surname)
                    println(xmlObj.age)
                }
            }
            return jsonObj
        }
        catch (ex:Exception){
            println(ex)
        }
        return null
    }
}