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
 * Vocabulary File. Created by org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Mon Oct 25 11:26:08 CEST 2010
 * input file: /src/main/resources/smiy/pmkb/vocabulary/mfo.owl
 * namespace: http://purl.org/ontology/mfo/
 */
public class MFO {

    /** Path to the ontology resource */
    public static final String MFO_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/mfo.owl";

    /**
     * Puts the MFO ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getMFOOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(MFO_RESOURCE_PATH, MFO.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + MFO_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for MFO */
    public static final URI NS_MFO = new URIImpl("http://purl.org/ontology/mfo/");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: CD  <br/>
     */
    public static final URI CD = new URIImpl("http://purl.org/ontology/mfo/CD");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: DVD  <br/>
     */
    public static final URI DVD = new URIImpl("http://purl.org/ontology/mfo/DVD");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: SACD  <br/>
     */
    public static final URI SACD = new URIImpl("http://purl.org/ontology/mfo/SACD");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: DualDisc  <br/>
     */
    public static final URI DualDisc = new URIImpl("http://purl.org/ontology/mfo/DualDisc");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: LaserDisc  <br/>
     */
    public static final URI LaserDisc = new URIImpl("http://purl.org/ontology/mfo/LaserDisc");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: MiniDisc  <br/>
     */
    public static final URI MiniDisc = new URIImpl("http://purl.org/ontology/mfo/MiniDisc");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Vinyl  <br/>
     */
    public static final URI Vinyl = new URIImpl("http://purl.org/ontology/mfo/Vinyl");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Cassette  <br/>
     */
    public static final URI Cassette = new URIImpl("http://purl.org/ontology/mfo/Cassette");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Cartridge  <br/>
     */
    public static final URI Cartridge = new URIImpl("http://purl.org/ontology/mfo/Cartridge");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Reel-to-reel  <br/>
     */
    public static final URI Reel_to_reel = new URIImpl("http://purl.org/ontology/mfo/Reel-to-reel");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: DAT  <br/>
     */
    public static final URI DAT = new URIImpl("http://purl.org/ontology/mfo/DAT");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Digital Media  <br/>
     */
    public static final URI Digital_Media = new URIImpl("http://purl.org/ontology/mfo/Digital_Media");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Other  <br/>
     */
    public static final URI Other = new URIImpl("http://purl.org/ontology/mfo/Other");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Wax Cylinder  <br/>
     */
    public static final URI Wax_Cylinder = new URIImpl("http://purl.org/ontology/mfo/Wax_Cylinder");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Piano Roll  <br/>
     */
    public static final URI Piano_Roll = new URIImpl("http://purl.org/ontology/mfo/Piano_Roll");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: DCC  <br/>
     */
    public static final URI DCC = new URIImpl("http://purl.org/ontology/mfo/DCC");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: HD-DVD  <br/>
     */
    public static final URI HD_DVD = new URIImpl("http://purl.org/ontology/mfo/HD-DVD");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: DVD-Audio  <br/>
     */
    public static final URI DVD_Audio = new URIImpl("http://purl.org/ontology/mfo/DVD-Audio");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: DVD-Video  <br/>
     */
    public static final URI DVD_Video = new URIImpl("http://purl.org/ontology/mfo/DVD-Video");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Blu-ray  <br/>
     */
    public static final URI Blu_ray = new URIImpl("http://purl.org/ontology/mfo/Blu-ray");
}
