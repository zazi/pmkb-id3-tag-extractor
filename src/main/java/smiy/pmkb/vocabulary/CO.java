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
 * input file: /src/main/resources/smiy/pmkb/vocabulary/counterontology.owl
 * namespace: http://purl.org/ontology/co/core#
 */
public class CO {

    /** Path to the ontology resource */
    public static final String CO_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/counterontology.owl";

    /**
     * Puts the CO ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getCOOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(CO_RESOURCE_PATH, CO.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + CO_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for CO */
    public static final URI NS_CO = new URIImpl("http://purl.org/ontology/co/core#");
    /**
     * Type: Class <br/>
     * Label: Counter@en  <br/>
     * Comment: Counter of a given object/ given objects, which are related to that counter.@en  <br/>
     */
    public static final URI Counter = new URIImpl("http://purl.org/ontology/co/core#Counter");
    /**
     * Type: Class <br/>
     * Label: Scrobble Event@en  <br/>
     * Comment: An event corresponding to a scrobbling (counting an activity, which includes at least a specific factor and 
a specific agent), e.g. a track being played by someone, a video watched by someone, a book read by 
someone, a sporting activity by someone, ...@en  <br/>
     */
    public static final URI ScrobbleEvent = new URIImpl("http://purl.org/ontology/co/core#ScrobbleEvent");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: has application@en  <br/>
     * Comment: An application that is related to a scrobble event, e.g. a iTunes to a play back event of a music track.@en  <br/>
     * Domain: http://purl.org/ontology/co/core#ScrobbleEvent  <br/>
     */
    public static final URI application = new URIImpl("http://purl.org/ontology/co/core#application");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#FunctionalProperty <br/>
     * Label: has count@en  <br/>
     * Comment: Links a counter resource to the actual count@en  <br/>
     * Domain: http://purl.org/ontology/co/core#Counter  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#integer  <br/>
     */
    public static final URI count = new URIImpl("http://purl.org/ontology/co/core#count");
    /**
     * Type: Property <br/>
     * Label: has counter@en  <br/>
     * Comment: Links an object to a counter resource. Please feel free to create further sub properties with more restricted domains.@en  <br/>
     * Range: http://purl.org/ontology/co/core#Counter  <br/>
     */
    public static final URI counter = new URIImpl("http://purl.org/ontology/co/core#counter");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: has device@en  <br/>
     * Comment: A device that is related to a scrobble event, e.g. a MP3 player to a play back event of a music track.@en  <br/>
     * Domain: http://purl.org/ontology/co/core#ScrobbleEvent  <br/>
     */
    public static final URI device = new URIImpl("http://purl.org/ontology/co/core#device");
    /**
     * Type: Property <br/>
     * Label: has event@en  <br/>
     * Comment: Links counter resources to related events.@en  <br/>
     * Range: http://purl.org/NET/c4dm/event.owl#Event  <br/>
     */
    public static final URI event = new URIImpl("http://purl.org/ontology/co/core#event");
    /**
     * Type: Property <br/>
     * Label: has event counter@en  <br/>
     * Comment: Links events to a counter resource, where they where counted in.@en  <br/>
     * Domain: http://purl.org/NET/c4dm/event.owl#Event  <br/>
     */
    public static final URI event_counter = new URIImpl("http://purl.org/ontology/co/core#event_counter");
    /**
     * Type: Property <br/>
     * Label: has object@en  <br/>
     * Comment: Links a counter resource to an object. Please feel free to create further sub properties with more restricted ranges.@en  <br/>
     * Domain: http://purl.org/ontology/co/core#Counter  <br/>
     */
    public static final URI object = new URIImpl("http://purl.org/ontology/co/core#object");
    /**
     * Type: Property <br/>
     * Label: has scrobble object@en  <br/>
     * Comment: A scrobble object of a scrobble event, e.g. a music track, a video or a described activity. That means a specific thing that is involved in this scrobbling action.@en  <br/>
     * Domain: http://purl.org/ontology/co/core#ScrobbleEvent  <br/>
     */
    public static final URI scrobble_object = new URIImpl("http://purl.org/ontology/co/core#scrobble_object");
}
