package StAXTest;

import StAXTest.dao.BankRepo;
import StAXTest.dao.MaterialRepo;
import StAXTest.dao.NomenclatureRepo;
import StAXTest.model.Bank;
import StAXTest.model.Material;
import StAXTest.model.Nomenclature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.xml.stream.*;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.*;

@Component
public class ParseXML {

    @Autowired
    private BankRepo bankRepo;

    @Autowired
    private  MaterialRepo materialRepo;

    @Autowired
    private  NomenclatureRepo nomenclatureRepo;

    private static Bank bank;
    private Nomenclature nomenclature;
    private static Material material;
    private static XMLEvent xmlEvent;
    private static XMLEventReader reader;

    public void parse(String fileName) {
        boolean isBank = false;
        boolean isMaterials = false;
        boolean isNomenclature = false;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("CatalogObject.Банки")) {
                        bank = new Bank();
                        isBank = true;
                        xmlEvent = reader.nextEvent();
                    } else
                    if (startElement.getName().getLocalPart().equals("Материалы")) {
                        material = new Material();
                        isMaterials = true;
                        xmlEvent = reader.nextEvent();
                    }else
                    if (startElement.getName().getLocalPart().equals("CatalogObject.Номенклатура")) {
                        nomenclature = new Nomenclature();
                        isNomenclature = true;
                        xmlEvent = reader.nextEvent();
                    }

                    if (isBank) parseBank(startElement);
                    if (isMaterials) parseMaterial(startElement);
                    if (isNomenclature) parseNomenclature(startElement);

                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("CatalogObject.Банки")) {
                        bankRepo.save(bank);
                        isBank = false;
                    } else
                    if (endElement.getName().getLocalPart().equals("Материалы")) {
                        materialRepo.save(material);
                        isMaterials = false;
                    } else
                    if (endElement.getName().getLocalPart().equals("CatalogObject.Номенклатура")) {
                        nomenclatureRepo.save(nomenclature);
                        isNomenclature = false;
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private void parseNomenclature(StartElement startElement) {
        try {
            switch (startElement.getName().getLocalPart()) {
                case "Code":
                    xmlEvent = reader.nextEvent();
                    nomenclature.setCode(xmlEvent.asCharacters().getData());
                    break;
                case "Description":
                    xmlEvent = reader.nextEvent();
                    nomenclature.setDescr(xmlEvent.asCharacters().getData());
                    break;
                case "ВидНоменклатуры":
                    xmlEvent = reader.nextEvent();
                    nomenclature.setType(xmlEvent.asCharacters().getData());
                    break;
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static void parseMaterial(StartElement startElement) {
        try {
            switch (startElement.getName().getLocalPart()) {
                case "Номенклатура":
                    xmlEvent = reader.nextEvent();
                    material.setNomenclature(xmlEvent.asCharacters().getData());
                    break;
                case "ЕдиницаИзмерения":
                    xmlEvent = reader.nextEvent();
                    material.setUnit(xmlEvent.asCharacters().getData());
                    break;
                case "Количество":
                    xmlEvent = reader.nextEvent();
                    material.setNumber(xmlEvent.asCharacters().getData());
                    break;
                case "Счет":
                    xmlEvent = reader.nextEvent();
                    material.setAccount(xmlEvent.asCharacters().getData());
                    break;
                case "Себестоимость":
                    xmlEvent = reader.nextEvent();
                    material.setCostPrice(xmlEvent.asCharacters().getData());
                    break;
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static void parseBank(StartElement startElement) {
        try {
            switch (startElement.getName().getLocalPart()) {
                case "Code":
                    xmlEvent = reader.nextEvent();
                    bank.setCode(xmlEvent.asCharacters().getData());
                    break;
                case "Description":
                    xmlEvent = reader.nextEvent();
                    bank.setName(xmlEvent.asCharacters().getData());
                    break;
                case "КоррСчет":
                    xmlEvent = reader.nextEvent();
                    bank.setKorAcc(xmlEvent.asCharacters().getData());
                    break;
                case "Адрес":
                    xmlEvent = reader.nextEvent();
                    bank.setAddress(xmlEvent.asCharacters().getData());
                    break;
                case "Телефоны":
                    xmlEvent = reader.nextEvent();
                    bank.setTel(xmlEvent.asCharacters().getData());
                    break;
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
