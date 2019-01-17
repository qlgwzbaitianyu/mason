package com.luxottica.ria.commonformat.utility;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;

/**
 * Created by Kevin Pontzloff on 6/9/2015.
 */
public class ConversionUtil {
    public static String marshalToXMLString(Class sourceObject, Object content) throws JAXBException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(sourceObject);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            StringWriter sw = new StringWriter();
            marshaller.marshal( content, sw );
            return sw.toString();
        } catch (Exception e) {
            throw new JAXBException(e);
        }
    }

    public static <T> T unMarshalXMLToObject(Class<T> destination, String xmlContent) throws JAXBException {
        try {
            if (StringUtils.isNotBlank(xmlContent)) {
                JAXBContext jaxbContext = JAXBContext.newInstance(destination);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                InputSource source = new InputSource(new ByteArrayInputStream(xmlContent.getBytes()));
                return destination.cast(unmarshaller.unmarshal(source));
            } else {
                return destination.newInstance();
            }
        } catch (Exception e) {
            throw new JAXBException(e);
        }
    }

    public static String marshalToJSONString(Object content) throws JAXBException {
        return marshalToJSONString(content, false);
    }

    public static String marshalToJSONString(Object content, boolean wrapInRoot) throws JAXBException {
        String jsonString = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            if (wrapInRoot) {
                mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            }
            jsonString = mapper.writeValueAsString(content);
        } catch (Exception e) {
            throw new JAXBException(e);
        }

        return jsonString;
    }

    public static <T> T unMarshalJSONToObject(Class<T> destination, String jsonContent) throws JAXBException {
        return unMarshalJSONToObject(destination, jsonContent, false);
    }

    public static <T> T unMarshalJSONToObject(Class<T> destination, String jsonContent, boolean unWrapRoot) throws JAXBException {
        try {
            if (StringUtils.isNotBlank(jsonContent)) {
                ObjectMapper mapper = new ObjectMapper();
                if (unWrapRoot) {
                    mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
                }
                return mapper.readValue(jsonContent, destination);
            } else {
                return destination.newInstance();
            }
        } catch (Exception e) {
            throw new JAXBException(e);
        }
    }
}

