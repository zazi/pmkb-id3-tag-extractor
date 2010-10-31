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
 * Vocabulary File. Created by org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Sun Oct 31 16:03:02 CET 2010
 * input file: /src/main/resources/smiy/pmkb/vocabulary/mediatypes.rdf
 * namespace: http://purl.org/ontology/mt/
 */
public class MT {

    /** Path to the ontology resource */
    public static final String MT_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/mediatypes.rdf";

    /**
     * Puts the MT ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getMTOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(MT_RESOURCE_PATH, MT.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + MT_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for MT */
    public static final URI NS_MT = new URIImpl("http://purl.org/ontology/mt/");
    /**
     * Type: Instance of http://purl.org/dc/terms/FileFormat and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: AAC  <br/>
     * Comment: Advanced Audio Coding used as medium to record an audio manifestation.  <br/>
     */
    public static final URI AAC = new URIImpl("http://purl.org/ontology/mt/AAC");
    /**
     * Type: Instance of http://purl.org/dc/terms/FileFormat and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: AIFF  <br/>
     * Comment: Audio Interchange File Format used as medium to record an audio manifestation.  <br/>
     */
    public static final URI AIFF = new URIImpl("http://purl.org/ontology/mt/AIFF");
    /**
     * Type: Instance of http://purl.org/dc/terms/MediaType and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: audio  <br/>
     * Comment: Audio used as medium to record an audio manifestation.  <br/>
     */
    public static final URI Audio = new URIImpl("http://purl.org/ontology/mt/Audio");
    /**
     * Type: Instance of http://purl.org/dc/terms/MediaType and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: audio file  <br/>
     * Comment: An audio file, which may be available on a local file system or through http, ftp, etc., used as medium to record an audio manifestation  <br/>
     */
    public static final URI AudioFile = new URIImpl("http://purl.org/ontology/mt/AudioFile");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: Betamax  <br/>
     * Comment: Betamax used as medium to record a video (and audio) manifestation.  <br/>
     */
    public static final URI Betamax = new URIImpl("http://purl.org/ontology/mt/Betamax");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: Blu-ray Disc  <br/>
     * Comment: Blu-ray Disc used as medium to record an audio and/or video manifestation.  <br/>
     */
    public static final URI BlueRayDisc = new URIImpl("http://purl.org/ontology/mt/BlueRayDisc");
    /**
     * Type: Instance of http://purl.org/dc/terms/MediaType and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: broadcast  <br/>
     * Comment: The distribution of audio and/or video content to a dispersed audience. Broadcast used as medium to distribute audio and/or video manifestations.  <br/>
     */
    public static final URI Broadcast = new URIImpl("http://purl.org/ontology/mt/Broadcast");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: CD  <br/>
     * Comment: Compact Disc used as medium to record an audio manifestation.  <br/>
     */
    public static final URI CD = new URIImpl("http://purl.org/ontology/mt/CD");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: cartridge  <br/>
     * Comment: Cartridge used as medium to record an audio manifestation.  <br/>
     */
    public static final URI Cartridge = new URIImpl("http://purl.org/ontology/mt/Cartridge");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: cassette  <br/>
     * Comment: Cassette used as medium to record an audio and/or video manifestation.  <br/>
     */
    public static final URI Cassette = new URIImpl("http://purl.org/ontology/mt/Cassette");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: Compact Cassette  <br/>
     * Comment: Compact Cassette used as medium to record an audio manifestation.  <br/>
     */
    public static final URI CompactCassette = new URIImpl("http://purl.org/ontology/mt/CompactCassettte");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: DAT  <br/>
     * Comment: Digital Audio Tape used as medium to record an audio manifestation.  <br/>
     */
    public static final URI DAT = new URIImpl("http://purl.org/ontology/mt/DAT");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: DCC  <br/>
     * Comment: Digital Compact Cassette used as medium to record an audio manifestation.  <br/>
     */
    public static final URI DCC = new URIImpl("http://purl.org/ontology/mt/DCC");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: DVD  <br/>
     * Comment: Digital Versatile Disc used as medium to record a manifestation.  <br/>
     */
    public static final URI DVD = new URIImpl("http://purl.org/ontology/mt/DVD");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: DVD-Audio  <br/>
     * Comment: DVD-Audio used as medium to record an audio manifestation.  <br/>
     */
    public static final URI DVDAudio = new URIImpl("http://purl.org/ontology/mt/DVDAudio");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: DVD-Video  <br/>
     * Comment: DVD-Video used as medium to record a video (and audio) manifestation.  <br/>
     */
    public static final URI DVDVideo = new URIImpl("http://purl.org/ontology/mt/DVDVideo");
    /**
     * Type: Instance of http://purl.org/dc/terms/MediaType and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: digital media  <br/>
     * Comment: Digital media used as medium to record a manifestation.  <br/>
     */
    public static final URI DigitalMedia = new URIImpl("http://purl.org/ontology/mt/DigitalMedia");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: DualDisc  <br/>
     * Comment: DualDisc used as medium to record am audio and/or video manifestation.  <br/>
     */
    public static final URI DualDisc = new URIImpl("http://purl.org/ontology/mt/DualDisc");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: EP record  <br/>
     * Comment: Extended Play record used as medium to record a musical manifestation.  <br/>
     */
    public static final URI EPRecord = new URIImpl("http://purl.org/ontology/mt/EPRecord");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: 8-track cartridge  <br/>
     * Comment: Lear Jet Stereo 8 used as medium to record an audio manifestation.  <br/>
     */
    public static final URI EightTrackCartridge = new URIImpl("http://purl.org/ontology/mt/EightTrackCartridge");
    /**
     * Type: Instance of http://purl.org/dc/terms/FileFormat and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: FLAC  <br/>
     * Comment: Free Lossless Audio Codec used as medium to record an audio manifestation.  <br/>
     */
    public static final URI FLAC = new URIImpl("http://purl.org/ontology/mt/FLAC");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: 4-track cartridge  <br/>
     * Comment: Muntz Stereo-Pak used as medium to record an audio manifestation.  <br/>
     */
    public static final URI FourTrackCartridge = new URIImpl("http://purl.org/ontology/mt/FourTrackCartridge");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: HDCD  <br/>
     * Comment: High Definition Compatible Digital used as medium to record an audio manifestation.  <br/>
     */
    public static final URI HDCD = new URIImpl("http://purl.org/ontology/mt/HDCD");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: HD-DVD  <br/>
     * Comment: High-Definition/Density DVD used as medium to record an audio and/or video manifestation.  <br/>
     */
    public static final URI HDDVD = new URIImpl("http://purl.org/ontology/mt/HDDVD");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: LP record  <br/>
     * Comment: Long-playing record used as medium to record a musical manifestation.  <br/>
     */
    public static final URI LPRecord = new URIImpl("http://purl.org/ontology/mt/LPRecord");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: LaserDisc  <br/>
     * Comment: LaserDisc used as medium to record a video (and audio) manifestation.  <br/>
     */
    public static final URI LaserDisc = new URIImpl("http://purl.org/ontology/mt/LaserDisc");
    /**
     * Type: Instance of http://purl.org/dc/terms/FileFormat and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: MP3  <br/>
     * Comment: MPEG-1 or MPEG-2 Audio Layer 3 (or III) used as medium to record an audio manifestation.  <br/>
     */
    public static final URI MP3 = new URIImpl("http://purl.org/ontology/mt/MP3");
    /**
     * Type: Instance of http://purl.org/dc/terms/FileFormat and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: MPC  <br/>
     * Comment: Musepack used as medium to record an audio manifestation.  <br/>
     */
    public static final URI MPC = new URIImpl("http://purl.org/ontology/mt/MPC");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: magnetic tape  <br/>
     * Comment: Magnetic analogue tape used as medium to record a manifestation.  <br/>
     */
    public static final URI MagneticTape = new URIImpl("http://purl.org/ontology/mt/MagneticTape");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: MiniDisc  <br/>
     * Comment: MiniDisc used as medium to record an audio manifestation.  <br/>
     */
    public static final URI MiniDisc = new URIImpl("http://purl.org/ontology/mt/MiniDisc");
    /**
     * Type: Instance of http://purl.org/dc/terms/FileFormat and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: Monkey's Audio  <br/>
     * Comment: Monkey's Audio used as medium to record an audio manifestation."  <br/>
     */
    public static final URI MonkeysAudio = new URIImpl("http://purl.org/ontology/mt/MonkeysAudio");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: NAB cartridge  <br/>
     * Comment: Fidelipac used as medium to record an audio manifestation.  <br/>
     */
    public static final URI NABCartridge = new URIImpl("http://purl.org/ontology/mt/NABCartridge");
    /**
     * Type: Instance of http://purl.org/dc/terms/FileFormat and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: OGG  <br/>
     * Comment: Ogg Vorbis used as medium to record an audio manifestation.  <br/>
     */
    public static final URI OGG = new URIImpl("http://purl.org/ontology/mt/OGG");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: optical disc  <br/>
     * Comment: Optical disc used as medium to record a manifestation.  <br/>
     */
    public static final URI OpticalDisc = new URIImpl("http://purl.org/ontology/mt/OpticalDisc");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: piano roll  <br/>
     * Comment: Piano roll used as medium to record a musical manifestation.  <br/>
     */
    public static final URI PianoRoll = new URIImpl("http://purl.org/ontology/mt/PianoRoll");
    /**
     * Type: Instance of http://purl.org/dc/terms/MediaType and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: radio  <br/>
     * Comment: An audio broadcast medium. Radio used as medium to distribute audio manifestations.  <br/>
     */
    public static final URI Radio = new URIImpl("http://purl.org/ontology/mt/Radio");
    /**
     * Type: Instance of http://purl.org/dc/terms/FileFormat and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: RealAudio  <br/>
     * Comment: RealAudio used as medium to record an audio manifestation.  <br/>
     */
    public static final URI RealAudio = new URIImpl("http://purl.org/ontology/mt/RealAudio");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: Reel-to-reel  <br/>
     * Comment: Reel-to-reel used as medium to record an audio manifestation.  <br/>
     */
    public static final URI ReelToReel = new URIImpl("http://purl.org/ontology/mt/ReelToReel");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: SACD  <br/>
     * Comment: Super Audio Compact Disc used as medium to record an audio manifestation.  <br/>
     */
    public static final URI SACD = new URIImpl("http://purl.org/ontology/mt/SACD");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: SVCD  <br/>
     * Comment: Compact Disc Digital Video used as medium to record a video (and audio) manifestation.  <br/>
     */
    public static final URI SVCD = new URIImpl("http://purl.org/ontology/mt/SVCD");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: S-VHS  <br/>
     * Comment: Super VHS used as medium to record a video (and audio) manifestation.  <br/>
     */
    public static final URI SVHS = new URIImpl("http://purl.org/ontology/mt/SVHS");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: slotMusic  <br/>
     * Comment: slotMusic used as medium to record an audio manifestation.  <br/>
     */
    public static final URI SlotMusic = new URIImpl("http://purl.org/ontology/mt/SlotMusic");
    /**
     * Type: Instance of http://purl.org/dc/terms/MediaType and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: stream  <br/>
     * Comment: Transmission over a network used as medium to broadcast audio and/or video manifestations.  <br/>
     */
    public static final URI Stream = new URIImpl("http://purl.org/ontology/mt/Stream");
    /**
     * Type: Instance of http://purl.org/dc/terms/MediaType and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: TV  <br/>
     * Comment: Television as an audio and video broadcast medium. TV used as medium to distribute video (and audio) manifestations.  <br/>
     */
    public static final URI TV = new URIImpl("http://purl.org/ontology/mt/TV");
    /**
     * Type: Instance of http://purl.org/dc/terms/MediaType and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: telephone  <br/>
     * Comment: Telephone used as medium to transmit a manifestation.  <br/>
     */
    public static final URI Telephone = new URIImpl("http://purl.org/ontology/mt/Telephone");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: UMD  <br/>
     * Comment: Universal Media Disc used as medium a manifestation (a game, a video, an music song).  <br/>
     */
    public static final URI UMD = new URIImpl("http://purl.org/ontology/mt/UMD");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: USB flash drive  <br/>
     * Comment: USB flash drive used as medium to record manifestations.  <br/>
     */
    public static final URI USBFlashDrive = new URIImpl("http://purl.org/ontology/mt/USBFlashDrive");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: VCD  <br/>
     * Comment: Compact Disc Digital Video used as medium to record a video (and audio) manifestation.  <br/>
     */
    public static final URI VCD = new URIImpl("http://purl.org/ontology/mt/VCD");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: VHS  <br/>
     * Comment: Video Home System used as medium to record an audio and/or video manifestation.  <br/>
     */
    public static final URI VHS = new URIImpl("http://purl.org/ontology/mt/VHS");
    /**
     * Type: Instance of http://purl.org/dc/terms/MediaType and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: video  <br/>
     * Comment: Video used as medium to record a video (and audio) manifestation.  <br/>
     */
    public static final URI Video = new URIImpl("http://purl.org/ontology/mt/Video");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: vinyl record  <br/>
     * Comment: Vinyl record used as medium to record an audio manifestation.  <br/>
     */
    public static final URI VinylRecord = new URIImpl("http://purl.org/ontology/mt/VinylRecord");
    /**
     * Type: Instance of http://purl.org/dc/terms/FileFormat and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: WAVE  <br/>
     * Comment: Waveform Audio File Format used as medium to record an audio manifestation.  <br/>
     */
    public static final URI WAVE = new URIImpl("http://purl.org/ontology/mt/WAVE");
    /**
     * Type: Instance of http://purl.org/dc/terms/FileFormat and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: WMA  <br/>
     * Comment: Windows Media Audio used as medium to record an audio manifestation.  <br/>
     */
    public static final URI WMA = new URIImpl("http://purl.org/ontology/mt/WMA");
    /**
     * Type: Instance of http://purl.org/dc/terms/PhysicalMedium and http://www.w3.org/2004/02/skos/core#Concept <br/>
     * Label: wax cylinder  <br/>
     * Comment: Wax cylinder used as medium to record a musical manifestation.  <br/>
     */
    public static final URI WaxCylinder = new URIImpl("http://purl.org/ontology/mt/WaxCylinder");
}
