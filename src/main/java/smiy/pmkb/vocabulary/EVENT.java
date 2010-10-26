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
 * Vocabulary File. Created by org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Mon Oct 25 15:13:02 CEST 2010
 * input file: /src/main/resources/smiy/pmkb/vocabulary/event.owl
 * namespace: http://purl.org/NET/c4dm/event.owl#
 */
public class EVENT {

    /** Path to the ontology resource */
    public static final String EVENT_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/event.owl";

    /**
     * Puts the EVENT ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getEVENTOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(EVENT_RESOURCE_PATH, EVENT.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + EVENT_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for EVENT */
    public static final URI NS_EVENT = new URIImpl("http://purl.org/NET/c4dm/event.owl#");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Event  <br/>
     * Comment: An arbitrary classification of a space/time region, by a 
		cognitive agent. An event may have actively participating agents,
		passive factors, products, and a location in space/time.  <br/>
     */
    public static final URI Event = new URIImpl("http://purl.org/NET/c4dm/event.owl#Event");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Factor  <br/>
     * Comment: Everything used as a factor in an event  <br/>
     */
    public static final URI Factor = new URIImpl("http://purl.org/NET/c4dm/event.owl#Factor");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Product  <br/>
     * Comment: Everything produced by an event  <br/>
     */
    public static final URI Product = new URIImpl("http://purl.org/NET/c4dm/event.owl#Product");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     */
    public static final URI hasLiteralFactor = new URIImpl("http://purl.org/NET/c4dm/event.owl#hasLiteralFactor");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: literal factor  <br/>
     * Comment: Relates an event to a factor which can be described as a literal. This property
		should not be used as-is, but should be subsumed by other, more specific, properties
		(like an hypothetic :weatherCelsius, linking an event to a temperature).  <br/>
     * Domain: http://purl.org/NET/c4dm/event.owl#Event  <br/>
     */
    public static final URI literal_factor = new URIImpl("http://purl.org/NET/c4dm/event.owl#literal_factor");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: agent  <br/>
     * Comment: Relates an event to an active agent (a person, a computer, ... :-) )  <br/>
     * Domain: http://purl.org/NET/c4dm/event.owl#Event  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI agent = new URIImpl("http://purl.org/NET/c4dm/event.owl#agent");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI agent_in = new URIImpl("http://purl.org/NET/c4dm/event.owl#agent_in");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: factor  <br/>
     * Comment: Relates an event to a passive factor (a tool, an instrument, an abstract cause...)  <br/>
     * Domain: http://purl.org/NET/c4dm/event.owl#Event  <br/>
     */
    public static final URI factor = new URIImpl("http://purl.org/NET/c4dm/event.owl#factor");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI factor_of = new URIImpl("http://purl.org/NET/c4dm/event.owl#factor_of");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI hasAgent = new URIImpl("http://purl.org/NET/c4dm/event.owl#hasAgent");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI hasFactor = new URIImpl("http://purl.org/NET/c4dm/event.owl#hasFactor");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI hasProduct = new URIImpl("http://purl.org/NET/c4dm/event.owl#hasProduct");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI hasSubEvent = new URIImpl("http://purl.org/NET/c4dm/event.owl#hasSubEvent");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: agent in  <br/>
     */
    public static final URI isAgentIn = new URIImpl("http://purl.org/NET/c4dm/event.owl#isAgentIn");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: factor of  <br/>
     */
    public static final URI isFactorOf = new URIImpl("http://purl.org/NET/c4dm/event.owl#isFactorOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: place  <br/>
     * Comment: Relates an event to a spatial object.  <br/>
     * Domain: http://purl.org/NET/c4dm/event.owl#Event  <br/>
     * Range: http://www.w3.org/2003/01/geo/wgs84_pos#SpatialThing  <br/>
     */
    public static final URI place = new URIImpl("http://purl.org/NET/c4dm/event.owl#place");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: produced in  <br/>
     */
    public static final URI producedIn = new URIImpl("http://purl.org/NET/c4dm/event.owl#producedIn");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI produced_in = new URIImpl("http://purl.org/NET/c4dm/event.owl#produced_in");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: product  <br/>
     * Comment: Relates an event to something produced during the event---a sound, a pie, whatever...  <br/>
     * Domain: http://purl.org/NET/c4dm/event.owl#Event  <br/>
     */
    public static final URI product = new URIImpl("http://purl.org/NET/c4dm/event.owl#product");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: sub-event  <br/>
     * Comment: This property provides a way to split a complex event (for example, a performance involving several 
		musicians) into simpler ones (one event per musician).  <br/>
     * Domain: http://purl.org/NET/c4dm/event.owl#Event  <br/>
     * Range: http://purl.org/NET/c4dm/event.owl#Event  <br/>
     */
    public static final URI sub_event = new URIImpl("http://purl.org/NET/c4dm/event.owl#sub_event");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: time  <br/>
     * Comment: Relates an event to a time object, classifying a time region (either instantaneous or having an extent).
		By using the Timeline ontology here, you can define event happening on a recorded track or on any 
		media with a temporal extent.  <br/>
     * Domain: http://purl.org/NET/c4dm/event.owl#Event  <br/>
     * Range: http://www.w3.org/2006/time#TemporalEntity  <br/>
     */
    public static final URI time = new URIImpl("http://purl.org/NET/c4dm/event.owl#time");
}
