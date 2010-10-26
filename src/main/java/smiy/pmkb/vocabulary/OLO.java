/*
 * Copyright (c) 2006 - 2010 Aduna and Deutsches Forschungszentrum fuer Kuenstliche Intelligenz DFKI GmbH.
 * All rights reserved.
 * 
 * Licensed under the Aperture BSD-style license.
 */
package smiy.pmkb.vocabulary;
import java.io.InputStream;
import java.io.FileNotFoundException;
import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.Syntax;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.model.node.impl.URIImpl;
import org.semanticdesktop.aperture.util.ResourceUtil;
/**
 * Vocabulary File. Created by org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Mon Oct 25 23:23:24 CEST 2010
 * input file: /src/main/resources/smiy/pmkb/vocabulary/orderedlistontology.owl
 * namespace: http://purl.org/ontology/olo/core#
 */
public class OLO {

    /** Path to the ontology resource */
    public static final String OLO_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/orderedlistontology.owl";

    /**
     * Puts the OLO ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getOLOOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(OLO_RESOURCE_PATH, OLO.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + OLO_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for OLO */
    public static final URI NS_OLO = new URIImpl("http://purl.org/ontology/olo/core#");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Ordered List@en  <br/>
     * Comment: An ordered list with a given length an indexed items.@en  <br/>
     */
    public static final URI OrderedList = new URIImpl("http://purl.org/ontology/olo/core#OrderedList");
    /**
     * Type: Class <br/>
     * Label: Slot@en  <br/>
     * Comment: A slot in an ordered list with a fixed index.@en  <br/>
     */
    public static final URI Slot = new URIImpl("http://purl.org/ontology/olo/core#Slot");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: has index@en  <br/>
     * Comment: An index of a slot in an ordered list.@en  <br/>
     * Domain: http://purl.org/ontology/olo/core#Slot  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#positiveInteger  <br/>
     */
    public static final URI index = new URIImpl("http://purl.org/ontology/olo/core#index");
    /**
     * Type: Property <br/>
     * Label: has item@en  <br/>
     * Comment: An item of a slot in an ordered list.@en  <br/>
     * Domain: http://purl.org/ontology/olo/core#Slot  <br/>
     */
    public static final URI item = new URIImpl("http://purl.org/ontology/olo/core#item");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: has length@en  <br/>
     * Comment: The length of an ordered list.@en  <br/>
     * Domain: http://purl.org/ontology/olo/core#OrderedList  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#nonNegativeInteger  <br/>
     */
    public static final URI length = new URIImpl("http://purl.org/ontology/olo/core#length");
    /**
     * Type: Property <br/>
     * Label: has next@en  <br/>
     * Comment: Associates the next slot in an ordered list.@en  <br/>
     * Domain: http://purl.org/ontology/olo/core#Slot  <br/>
     * Range: http://purl.org/ontology/olo/core#Slot  <br/>
     */
    public static final URI next = new URIImpl("http://purl.org/ontology/olo/core#next");
    /**
     * Type: Property <br/>
     * Label: has ordered list@en  <br/>
     * Comment: An ordered list of an slot.@en  <br/>
     * Domain: http://purl.org/ontology/olo/core#Slot  <br/>
     * Range: http://purl.org/ontology/olo/core#OrderedList  <br/>
     */
    public static final URI ordered_list = new URIImpl("http://purl.org/ontology/olo/core#ordered_list");
    /**
     * Type: Property <br/>
     * Label: has previous@en  <br/>
     * Comment: Associates the previous slot in an ordered list@en  <br/>
     * Domain: http://purl.org/ontology/olo/core#Slot  <br/>
     * Range: http://purl.org/ontology/olo/core#Slot  <br/>
     */
    public static final URI previous = new URIImpl("http://purl.org/ontology/olo/core#previous");
    /**
     * Type: Property <br/>
     * Label: has slot@en  <br/>
     * Comment: A slot in an ordered list.@en  <br/>
     * Domain: http://purl.org/ontology/olo/core#OrderedList  <br/>
     * Range: http://purl.org/ontology/olo/core#Slot  <br/>
     */
    public static final URI slot = new URIImpl("http://purl.org/ontology/olo/core#slot");
}
