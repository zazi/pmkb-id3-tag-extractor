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
 * Vocabulary File. Created by org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Mon Oct 25 11:26:07 CEST 2010
 * input file: /src/main/resources/smiy/pmkb/vocabulary/dc.rdfs
 * namespace: http://purl.org/dc/elements/1.1/
 */
public class DC {

    /** Path to the ontology resource */
    public static final String DC_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/dc.rdfs";

    /**
     * Puts the DC ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getDCOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(DC_RESOURCE_PATH, DC.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + DC_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for DC */
    public static final URI NS_DC = new URIImpl("http://purl.org/dc/elements/1.1/");
    /**
     * Type: Property <br/>
     * Label: Title@en-us  <br/>
     * Comment: A name given to the resource.@en-us  <br/>
     */
    public static final URI title = new URIImpl("http://purl.org/dc/elements/1.1/title");
    /**
     * Type: Property <br/>
     * Label: Creator@en-us  <br/>
     * Comment: An entity primarily responsible for making the resource.@en-us  <br/>
     */
    public static final URI creator = new URIImpl("http://purl.org/dc/elements/1.1/creator");
    /**
     * Type: Property <br/>
     * Label: Subject@en-us  <br/>
     * Comment: The topic of the resource.@en-us  <br/>
     */
    public static final URI subject = new URIImpl("http://purl.org/dc/elements/1.1/subject");
    /**
     * Type: Property <br/>
     * Label: Description@en-us  <br/>
     * Comment: An account of the resource.@en-us  <br/>
     */
    public static final URI description = new URIImpl("http://purl.org/dc/elements/1.1/description");
    /**
     * Type: Property <br/>
     * Label: Publisher@en-us  <br/>
     * Comment: An entity responsible for making the resource available.@en-us  <br/>
     */
    public static final URI publisher = new URIImpl("http://purl.org/dc/elements/1.1/publisher");
    /**
     * Type: Property <br/>
     * Label: Contributor@en-us  <br/>
     * Comment: An entity responsible for making contributions to the resource.@en-us  <br/>
     */
    public static final URI contributor = new URIImpl("http://purl.org/dc/elements/1.1/contributor");
    /**
     * Type: Property <br/>
     * Label: Date@en-us  <br/>
     * Comment: A point or period of time associated with an event in the lifecycle of the resource.@en-us  <br/>
     */
    public static final URI date = new URIImpl("http://purl.org/dc/elements/1.1/date");
    /**
     * Type: Property <br/>
     * Label: Type@en-us  <br/>
     * Comment: The nature or genre of the resource.@en-us  <br/>
     */
    public static final URI type = new URIImpl("http://purl.org/dc/elements/1.1/type");
    /**
     * Type: Property <br/>
     * Label: Format@en-us  <br/>
     * Comment: The file format, physical medium, or dimensions of the resource.@en-us  <br/>
     */
    public static final URI format = new URIImpl("http://purl.org/dc/elements/1.1/format");
    /**
     * Type: Property <br/>
     * Label: Identifier@en-us  <br/>
     * Comment: An unambiguous reference to the resource within a given context.@en-us  <br/>
     */
    public static final URI identifier = new URIImpl("http://purl.org/dc/elements/1.1/identifier");
    /**
     * Type: Property <br/>
     * Label: Source@en-us  <br/>
     * Comment: A related resource from which the described resource is derived.@en-us  <br/>
     */
    public static final URI source = new URIImpl("http://purl.org/dc/elements/1.1/source");
    /**
     * Type: Property <br/>
     * Label: Language@en-us  <br/>
     * Comment: A language of the resource.@en-us  <br/>
     */
    public static final URI language = new URIImpl("http://purl.org/dc/elements/1.1/language");
    /**
     * Type: Property <br/>
     * Label: Relation@en-us  <br/>
     * Comment: A related resource.@en-us  <br/>
     */
    public static final URI relation = new URIImpl("http://purl.org/dc/elements/1.1/relation");
    /**
     * Type: Property <br/>
     * Label: Coverage@en-us  <br/>
     * Comment: The spatial or temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction under which the resource is relevant.@en-us  <br/>
     */
    public static final URI coverage = new URIImpl("http://purl.org/dc/elements/1.1/coverage");
    /**
     * Type: Property <br/>
     * Label: Rights@en-us  <br/>
     * Comment: Information about rights held in and over the resource.@en-us  <br/>
     */
    public static final URI rights = new URIImpl("http://purl.org/dc/elements/1.1/rights");
}
