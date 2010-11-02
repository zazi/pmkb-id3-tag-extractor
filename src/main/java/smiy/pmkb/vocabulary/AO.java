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
 * Vocabulary File. Created by org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Tue Nov 02 19:26:24 CET 2010
 * input file: /src/main/resources/smiy/pmkb/vocabulary/ao.owl
 * namespace: http://purl.org/ontology/ao/core#
 */
public class AO {

    /** Path to the ontology resource */
    public static final String AO_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/ao.owl";

    /**
     * Puts the AO ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getAOOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(AO_RESOURCE_PATH, AO.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + AO_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for AO */
    public static final URI NS_AO = new URIImpl("http://purl.org/ontology/ao/core#");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Likeable Association@en  <br/>
     * Comment: A likeable association. That means this association type is intended to be used for voting (ao:likeminded), 
feedbacking (rev:Feedback), reviewing (e.g. rev:rating) an association statement (related by ao:included_association) in the 
context of something.@en  <br/>
     */
    public static final URI LikeableAssociation = new URIImpl("http://purl.org/ontology/ao/core#LikeableAssociation");
    /**
     * Type: Property <br/>
     * Label: has activity@en  <br/>
     * Comment: An activity, which is associated to an individual, e.g. dancing, sleeping, driving.@en  <br/>
     */
    public static final URI activity = new URIImpl("http://purl.org/ontology/ao/core#activity");
    /**
     * Type: Property <br/>
     * Label: has application@en  <br/>
     * Comment: An application, which is associated to an individual, e.g. a music player to a music track it's currently playing back.@en  <br/>
     */
    public static final URI application = new URIImpl("http://purl.org/ontology/ao/core#application");
    /**
     * Type: Property <br/>
     * Label: has context@en  <br/>
     * Comment: A property to associate any environmental context to an individual, e.g. a location, a time or an activity. Hence, this property is intended that sub properties should be created from it.@en  <br/>
     * Domain: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI context = new URIImpl("http://purl.org/ontology/ao/core#context");
    /**
     * Type: Property <br/>
     * Label: has device@en  <br/>
     * Comment: A device, which is associated with an individual, e.g. a CD player with a CD it's currently playing back.@en  <br/>
     */
    public static final URI device = new URIImpl("http://purl.org/ontology/ao/core#device");
    /**
     * Type: Property <br/>
     * Label: has genre@en  <br/>
     * Comment: An genre of something.@en  <br/>
     * Domain: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI genre = new URIImpl("http://purl.org/ontology/ao/core#genre");
    /**
     * Type: Property <br/>
     * Label: has location@en  <br/>
     * Comment: A location, which is associated to an individual, e.g. my house, my country, my current whereabouts.@en  <br/>
     */
    public static final URI location = new URIImpl("http://purl.org/ontology/ao/core#location");
    /**
     * Type: Property <br/>
     * Label: has mood@en  <br/>
     * Comment: A mood that should be created by something.@en  <br/>
     * Domain: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI mood = new URIImpl("http://purl.org/ontology/ao/core#mood");
    /**
     * Type: Property <br/>
     * Label: has occassion@en  <br/>
     * Comment: An occasion for which something was created.@en  <br/>
     * Domain: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI occasion = new URIImpl("http://purl.org/ontology/ao/core#occasion");
    /**
     * Type: Property <br/>
     * Label: has time@en  <br/>
     * Comment: A time, which is associated to an individual, e.g. morning, afternoon, evening.@en  <br/>
     */
    public static final URI time = new URIImpl("http://purl.org/ontology/ao/core#time");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: has used application@en  <br/>
     * Comment: An application that is related to an event, e.g. a iTunes to a play back event of a music track.@en  <br/>
     */
    public static final URI used_application = new URIImpl("http://purl.org/ontology/ao/core#used_application");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: has used device@en  <br/>
     * Comment: A device that is related to an event, e.g. a MP3 player to a play back event of a music track.@en  <br/>
     */
    public static final URI used_device = new URIImpl("http://purl.org/ontology/ao/core#used_device");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: has included association@en  <br/>
     * Comment: This property could be used to compose association statements or to reuse them, e.g. to make them likeable 
in a specific context.@en  <br/>
     * Domain: http://purl.org/ontology/similarity/Association  <br/>
     * Range: http://purl.org/ontology/similarity/Association  <br/>
     */
    public static final URI included_association = new URIImpl("http://purl.org/ontology/ao/core#included_association");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: has likeminded^^http://www.w3.org/2001/XMLSchema#string  <br/>
     * Comment: Associates likeminded people to an association, which they like/ agree with.^^http://www.w3.org/2001/XMLSchema#string  <br/>
     * Domain: http://purl.org/ontology/similarity/Association  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI likeminded = new URIImpl("http://purl.org/ontology/ao/core#likeminded");
}
