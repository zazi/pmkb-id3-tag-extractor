/*
 * Copyright (c) 2006 - 2008 Aduna and Deutsches Forschungszentrum fuer Kuenstliche Intelligenz DFKI GmbH.
 * All rights reserved.
 * 
 * Licensed under the Aperture BSD-style license.
 */
package smiy.pmkb.extractor.audiodocuments.mp3;

import org.ontoware.rdf2go.model.node.impl.URIImpl;
import org.ontoware.rdf2go.vocabulary.RDF;
import org.ontoware.rdf2go.vocabulary.XSD;
import org.semanticdesktop.aperture.rdf.RDFContainer;
import org.semanticdesktop.aperture.test.extractor.FileExtractorTestBase;
import org.semanticdesktop.aperture.vocabulary.NID3;

/**
 * Tests for the MP3FileExtractor
 */
public class ID3V2_3_0Test extends FileExtractorTestBase {

    /**
     * The jingle3.mp3 contains some ID3 2.3.0 frames inserted with the kid3 tool
     */
    public void testJingle3() throws Exception {
        MP3FileExtractor extractor = new MP3FileExtractor();
        RDFContainer metadata = extract(DOCS_PATH + "jingle3.mp3", extractor);
        checkStatement(RDF.type, NID3.ID3Audio, metadata);
        checkStatement(NID3.title, "Aperture Jingle 3", metadata);
        checkSimpleContact(NID3.leadArtist, "Antoni the Lead Artist Mylka", metadata);
        checkStatement(NID3.albumTitle, "The Aperture test album", metadata);
        checkStatement(NID3.comments, "The comment", metadata);
        checkStatement(metadata.getDescribedUri(), NID3.recordingYear, metadata.getModel()
                .createDatatypeLiteral("2007", XSD._integer), metadata);
        checkStatement(NID3.trackNumber, "5", metadata);
        // we want content types stored as plain strings
        checkStatement(NID3.contentType, "Pop", metadata);
        checkSimpleContact(NID3.interpretedBy, "Antoni the Arranger Mylka", metadata);
        checkSimpleContact(NID3.originalTextWriter, "Antoni the Original Lyricist Mylka", metadata);
        checkStatement(metadata.getDescribedUri(), NID3.beatsPerMinute, metadata.getModel()
                .createDatatypeLiteral("230", XSD._integer), metadata);
        checkSimpleContact(NID3.composer, "Antoni the Composer Mylka", metadata);
        checkSimpleContact(NID3.conductor, "Antoni the Conductor Mylka", metadata);
        checkStatement(NID3.copyrightMessage, "Antoni the Copyright Holder Mylka", metadata);
        checkStatement(NID3.partOfSet, "3", metadata);
        checkSimpleContact(NID3.encodedBy, "Antoni the Encoder Mylka", metadata);
        checkStatement(NID3.internationalStandardRecordingCode, "dfsdf:34234:asdf", metadata);
        checkStatement(NID3.language,"eng",metadata);
        checkSimpleContact(NID3.textWriter, "Antoni the Lyricist Mylka", metadata);
        checkStatement(NID3.originalAlbumTitle,"The Aperture Original Test Album",metadata);
        checkSimpleContact(NID3.originalArtist, "Antoni the Original Artist Mylka", metadata);
        checkStatement(metadata.getDescribedUri(), NID3.originalReleaseYear, metadata.getModel()
            .createDatatypeLiteral("1956", XSD._integer), metadata);
        checkSimpleContact(NID3.backgroundArtist, "Antoni the Orchestra Mylka", metadata);
        checkSimpleContact(NID3.publisher, "Antoni the Publisher Mylka", metadata);
        checkStatement(NID3.subtitle, "The subtitle test, description refinement", metadata);
        checkStatement(NID3.officialArtistWebpage, new URIImpl("http://www.antoni.com/performer/webpage.html"), metadata);
        validate(metadata);
    }
}
