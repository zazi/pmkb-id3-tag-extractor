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
 * input file: /src/main/resources/smiy/pmkb/vocabulary/playbackontology.owl
 * namespace: http://purl.org/ontology/pbo/core#
 */
public class PBO {

    /** Path to the ontology resource */
    public static final String PBO_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/playbackontology.owl";

    /**
     * Puts the PBO ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getPBOOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(PBO_RESOURCE_PATH, PBO.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + PBO_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for PBO */
    public static final URI NS_PBO = new URIImpl("http://purl.org/ontology/pbo/core#");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Fixed Playlist@en  <br/>
     * Comment: A (sub) playlist of a fixed length and a fixed order. This concept should be used to express static relations, 
e.g. "those three music tracks must always be played in a row".@en  <br/>
     */
    public static final URI FixedPlaylist = new URIImpl("http://purl.org/ontology/pbo/core#FixedPlaylist");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Media Action Counter@en  <br/>
     * Comment: A media action counter. Media actions are for example play back or skip events.^^http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI MediaActionCounter = new URIImpl("http://purl.org/ontology/pbo/core#MediaActionCounter");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Play Back Counter@en  <br/>
     * Comment: A play back counter, e.g. to count the playback of a media object.^^http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI PlayBackCounter = new URIImpl("http://purl.org/ontology/pbo/core#PlayBackCounter");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Playlist@en  <br/>
     * Comment: A playlist of specific media items, e.g. music tracks, videos or slides.@en  <br/>
     */
    public static final URI Playlist = new URIImpl("http://purl.org/ontology/pbo/core#Playlist");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Playlist Slot@en  <br/>
     * Comment: A playlist slot. It could contain e.g. a music track, a video or a slide, and maybe related with some 
additional properties. However, it could maybe also included a "sub" playlist, e.g. to keep a fixed sequence of some tracks.@en  <br/>
     */
    public static final URI PlaylistSlot = new URIImpl("http://purl.org/ontology/pbo/core#PlaylistSlot");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Skip Counter^^http://www.w3.org/2001/XMLSchema#string  <br/>
     * Comment: A skip counter, e.g. to count skip events of a media object.^^http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI SkipCounter = new URIImpl("http://purl.org/ontology/pbo/core#SkipCounter");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Skip Event^^http://www.w3.org/2001/XMLSchema#string  <br/>
     * Comment: A specific skip event of something.^^http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI SkipEvent = new URIImpl("http://purl.org/ontology/pbo/core#SkipEvent");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: has media object@en  <br/>
     * Comment: Associates a media object to its related counter.@en  <br/>
     * Domain: http://purl.org/ontology/pbo/core#MediaActionCounter  <br/>
     * Range: _:node15fikcd19x2  <br/>
     */
    public static final URI media_object = new URIImpl("http://purl.org/ontology/pbo/core#media_object");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: has media scrobble object@en  <br/>
     * Comment: A media specific scrobble object, e.g. a music track or a video.@en  <br/>
     * Range: _:node15fikcd19x5  <br/>
     */
    public static final URI media_scrobble_object = new URIImpl("http://purl.org/ontology/pbo/core#media_scrobble_object");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: has playlist@en  <br/>
     * Comment: Associates a playlist to something.@en  <br/>
     * Domain: http://www.w3.org/2002/07/owl#Thing  <br/>
     * Range: http://purl.org/ontology/pbo/core#Playlist  <br/>
     */
    public static final URI playlist = new URIImpl("http://purl.org/ontology/pbo/core#playlist");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: has playlist item@en  <br/>
     * Comment: A specific playlist item, e.g. a music track, video or slides. The range types of this property must be 
based on bibo:Document or frbr:Endeavour (to keep it somehow media based).@en  <br/>
     * Domain: http://purl.org/ontology/pbo/core#PlaylistSlot  <br/>
     * Range: _:node15fikcd19x8  <br/>
     */
    public static final URI playlist_item = new URIImpl("http://purl.org/ontology/pbo/core#playlist_item");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: has playlist slot@en  <br/>
     * Comment: A specific slot in a playlist.@en  <br/>
     * Domain: http://purl.org/ontology/pbo/core#Playlist  <br/>
     * Range: http://purl.org/ontology/pbo/core#PlaylistSlot  <br/>
     */
    public static final URI playlist_slot = new URIImpl("http://purl.org/ontology/pbo/core#playlist_slot");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: has skip time^^http://www.w3.org/2001/XMLSchema#string  <br/>
     * Comment: The moment, when someone skipped the media object, e.g. an instant of a timeline of an audio signal.^^http://www.w3.org/2001/XMLSchema#string  <br/>
     * Domain: http://purl.org/ontology/pbo/core#SkipEvent  <br/>
     */
    public static final URI skip_time = new URIImpl("http://purl.org/ontology/pbo/core#skip_time");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: has transition@en  <br/>
     * Comment: This relation directs to a description of a transition between two neighbouring playlist slots, e.g. two successive music tracks in a dj mix.@en  <br/>
     * Domain: http://purl.org/ontology/pbo/core#PlaylistSlot  <br/>
     */
    public static final URI transition = new URIImpl("http://purl.org/ontology/pbo/core#transition");
}
