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
 * Vocabulary File. Created by org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Tue Oct 26 20:10:25 CEST 2010
 * input file: /src/main/resources/smiy/pmkb/vocabulary/keys.owl
 * namespace: http://purl.org/NET/c4dm/keys.owl#
 */
public class KEYS {

    /** Path to the ontology resource */
    public static final String KEYS_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/keys.owl";

    /**
     * Puts the KEYS ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getKEYSOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(KEYS_RESOURCE_PATH, KEYS.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + KEYS_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for KEYS */
    public static final URI NS_KEYS = new URIImpl("http://purl.org/NET/c4dm/keys.owl#");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     */
    public static final URI Note = new URIImpl("http://purl.org/NET/c4dm/keys.owl#Note");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     */
    public static final URI Key = new URIImpl("http://purl.org/NET/c4dm/keys.owl#Key");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI AFlat = new URIImpl("http://purl.org/NET/c4dm/keys.owl#AFlat");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI C = new URIImpl("http://purl.org/NET/c4dm/keys.owl#C");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI F = new URIImpl("http://purl.org/NET/c4dm/keys.owl#F");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI BFlat = new URIImpl("http://purl.org/NET/c4dm/keys.owl#BFlat");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI EFlat = new URIImpl("http://purl.org/NET/c4dm/keys.owl#EFlat");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI B = new URIImpl("http://purl.org/NET/c4dm/keys.owl#B");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI FSharp = new URIImpl("http://purl.org/NET/c4dm/keys.owl#FSharp");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI GFlat = new URIImpl("http://purl.org/NET/c4dm/keys.owl#GFlat");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI DFlat = new URIImpl("http://purl.org/NET/c4dm/keys.owl#DFlat");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI CSharp = new URIImpl("http://purl.org/NET/c4dm/keys.owl#CSharp");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI DSharp = new URIImpl("http://purl.org/NET/c4dm/keys.owl#DSharp");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI G = new URIImpl("http://purl.org/NET/c4dm/keys.owl#G");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI E = new URIImpl("http://purl.org/NET/c4dm/keys.owl#E");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI GSharp = new URIImpl("http://purl.org/NET/c4dm/keys.owl#GSharp");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI A = new URIImpl("http://purl.org/NET/c4dm/keys.owl#A");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI ASharp = new URIImpl("http://purl.org/NET/c4dm/keys.owl#ASharp");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI CFlat = new URIImpl("http://purl.org/NET/c4dm/keys.owl#CFlat");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Note <br/>
     */
    public static final URI D = new URIImpl("http://purl.org/NET/c4dm/keys.owl#D");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI CMajor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#CMajor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI AFlatMinor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#AFlatMinor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI FMajor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#FMajor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI FMinor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#FMinor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI BFlatMinor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#BFlatMinor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI EFlatMinor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#EFlatMinor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI CMinor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#CMinor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI DSharpMinor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#DSharpMinor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI DFlatMajor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#DFlatMajor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI GSharpMinor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#GSharpMinor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI AMinor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#AMinor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI EMinor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#EMinor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI FSharpMajor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#FSharpMajor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI EMajor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#EMajor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI GMinor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#GMinor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI AMajor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#AMajor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI CSharpMajor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#CSharpMajor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI FSharpMinor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#FSharpMinor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI CSharpMinor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#CSharpMinor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI DMajor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#DMajor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI GFlatMajor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#GFlatMajor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI BMinor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#BMinor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI AFlatMajor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#AFlatMajor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI GMajor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#GMajor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI EFlatMajor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#EFlatMajor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI CFlatMajor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#CFlatMajor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI BMajor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#BMajor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI ASharpMinor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#ASharpMinor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI DMinor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#DMinor");
    /**
     * Type: Instance of http://purl.org/NET/c4dm/keys.owl#Key <br/>
     */
    public static final URI BFlatMajor = new URIImpl("http://purl.org/NET/c4dm/keys.owl#BFlatMajor");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Range: http://www.w3.org/2001/XMLSchema#anyURI  <br/>
     */
    public static final URI wikipedia = new URIImpl("http://purl.org/NET/c4dm/keys.owl#wikipedia");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Domain: http://purl.org/NET/c4dm/keys.owl#Key  <br/>
     * Range: _:node15fkrnnujx1  <br/>
     */
    public static final URI mode = new URIImpl("http://purl.org/NET/c4dm/keys.owl#mode");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Domain: http://purl.org/NET/c4dm/keys.owl#Key  <br/>
     */
    public static final URI tonic = new URIImpl("http://purl.org/NET/c4dm/keys.owl#tonic");
}
