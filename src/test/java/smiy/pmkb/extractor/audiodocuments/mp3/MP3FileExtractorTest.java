/*
 * Copyright (c) 2006 - 2008 Aduna and Deutsches Forschungszentrum fuer Kuenstliche Intelligenz DFKI GmbH.
 * All rights reserved.
 * 
 * Licensed under the Aperture BSD-style license.
 */
package smiy.pmkb.extractor.audiodocuments.mp3;

import org.ontoware.rdf2go.vocabulary.RDF;
import org.ontoware.rdf2go.vocabulary.XSD;
import org.semanticdesktop.aperture.rdf.RDFContainer;
import org.semanticdesktop.aperture.test.extractor.FileExtractorTestBase;
import org.semanticdesktop.aperture.vocabulary.NID3;

/**
 * Tests for the MP3FileExtractor
 */
public class MP3FileExtractorTest extends FileExtractorTestBase {

    /**
     * The jingle1.mp3 contains all possible ID3 v1.1 tags and no ID3v2 tags. 
     * @throws Exception
     */
    public void testJingle1() throws Exception {
        MP3FileExtractor extractor = new MP3FileExtractor();
        RDFContainer metadata = extract(DOCS_PATH + "jingle1.mp3", extractor);
        checkStatement(RDF.type, NID3.ID3Audio, metadata);
        checkStatement(NID3.title, "Aperture Jingle 1", metadata);
        checkSimpleContact(NID3.leadArtist, "Antoni Mylka", metadata);
        checkStatement(NID3.albumTitle, "Aperture test album", metadata);
        checkStatement(NID3.comments,"Test for ID3 v. 1.1",metadata);
        checkStatement(metadata.getDescribedUri(), NID3.recordingYear, metadata.getModel()
                .createDatatypeLiteral("2007", XSD._integer), metadata);
        checkStatement(NID3.trackNumber, "2", metadata);
        checkStatement(NID3.contentType,"Instrumental",metadata);
        validate(metadata);
        metadata.dispose();
    }
    
    /**
     * The jingle2.mp3 contains only ID3 v1.0 tags (no trackNumber) and the
     * album is missing, so that we can see if the extractor actually supports
     * incomplete data
     * @throws Exception
     */
    public void testJingle2() throws Exception {
        MP3FileExtractor extractor = new MP3FileExtractor();
        RDFContainer metadata = extract(DOCS_PATH + "jingle2.mp3", extractor);
        checkStatement(RDF.type, NID3.ID3Audio, metadata);
        checkStatement(NID3.title, "Aperture jingle 2", metadata);
        checkSimpleContact(NID3.leadArtist, "Antoni Mylka", metadata);
        
        checkStatement(metadata.getDescribedUri(), NID3.recordingYear, metadata.getModel()
                .createDatatypeLiteral("2007", XSD._integer), metadata);
        checkStatement(NID3.contentType,"Death Metal",metadata);   
        assertTrue(metadata.getAll(NID3.albumTitle).size() == 0);
        assertTrue(metadata.getAll(NID3.trackNumber).size() == 0);
        validate(metadata);
        metadata.dispose();
    }
}
