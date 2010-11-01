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
 * Vocabulary File. Created by org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Mon Nov 01 16:05:00 CET 2010
 * input file: /src/main/resources/smiy/pmkb/vocabulary/mo.owl
 * namespace: http://purl.org/ontology/mo/
 */
public class MO {

    /** Path to the ontology resource */
    public static final String MO_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/mo.owl";

    /**
     * Puts the MO ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getMOOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(MO_RESOURCE_PATH, MO.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + MO_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for MO */
    public static final URI NS_MO = new URIImpl("http://purl.org/ontology/mo/");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: analogue signal  <br/>
     * Comment: An analog signal.  <br/>
     */
    public static final URI AnalogSignal = new URIImpl("http://purl.org/ontology/mo/AnalogSignal");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: arrangement  <br/>
     * Comment: An arrangement event.
		Takes as agent the arranger, and produces a score (informational object, not the actually published score).  <br/>
     */
    public static final URI Arrangement = new URIImpl("http://purl.org/ontology/mo/Arrangement");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: arranger  <br/>
     */
    public static final URI Arranger = new URIImpl("http://purl.org/ontology/mo/Arranger");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: audio file  <br/>
     * Comment: An audio file, which may be available on a local file system or through http, ftp, etc.  <br/>
     */
    public static final URI AudioFile = new URIImpl("http://purl.org/ontology/mo/AudioFile");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: CD  <br/>
     * Comment: Compact Disc used as medium to record a musical manifestation.  <br/>
     */
    public static final URI CD = new URIImpl("http://purl.org/ontology/mo/CD");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: composer  <br/>
     */
    public static final URI Composer = new URIImpl("http://purl.org/ontology/mo/Composer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: composition  <br/>
     * Comment: A composition event.
		Takes as agent the composer himself.
		It produces a MusicalWork, or a MusicalExpression (when the initial "product" is a score, for example), or both...  <br/>
     */
    public static final URI Composition = new URIImpl("http://purl.org/ontology/mo/Composition");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: conductor  <br/>
     */
    public static final URI Conductor = new URIImpl("http://purl.org/ontology/mo/Conductor");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: corporate body  <br/>
     * Comment: Organization or group of individuals and/or other organizations involved in the music market.  <br/>
     */
    public static final URI CorporateBody = new URIImpl("http://purl.org/ontology/mo/CorporateBody");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: DAT  <br/>
     * Comment: Digital Audio Tape used as medium to record a musical manifestation.^^http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI DAT = new URIImpl("http://purl.org/ontology/mo/DAT");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: DCC  <br/>
     * Comment: Digital Compact Cassette used as medium to record a musical manifestation.  <br/>
     */
    public static final URI DCC = new URIImpl("http://purl.org/ontology/mo/DCC");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: DVDA  <br/>
     * Comment: DVD-Audio used as medium to record a musical manifestation.  <br/>
     */
    public static final URI DVDA = new URIImpl("http://purl.org/ontology/mo/DVDA");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: digital signal  <br/>
     * Comment: A digital signal  <br/>
     */
    public static final URI DigitalSignal = new URIImpl("http://purl.org/ontology/mo/DigitalSignal");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: ED2K  <br/>
     * Comment: Something available on the E-Donkey peer-2-peer filesharing network  <br/>
     */
    public static final URI ED2K = new URIImpl("http://purl.org/ontology/mo/ED2K");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Festival  <br/>
     * Comment: A festival - musical/artistic event lasting several days, like Glastonbury, Rock Am Ring...
		We migth decompose this event (which is in fact just a classification of the space/time region related to 
		a particular festival) using hasSubEvent in several performances at different space/time.  <br/>
     */
    public static final URI Festival = new URIImpl("http://purl.org/ontology/mo/Festival");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Genre  <br/>
     * Comment: An expressive style of music.
		
		Any taxonomy can be plug-in here. You can either define a genre by yourself, like this:

		:mygenre a mo:Genre; dc:title "electro rock".

		Or you can refer to a DBPedia genre (such as http://dbpedia.org/resource/Baroque_music), allowing semantic web
		clients to access easily really detailed structured information about the genre you are refering to.  <br/>
     */
    public static final URI Genre = new URIImpl("http://purl.org/ontology/mo/Genre");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Instrument  <br/>
     * Comment: Any of various devices or contrivances that can be used to produce musical tones or sound.
		
		Any taxonomy can be used to subsume this concept. The default one is one extracted by Ivan Herman
		from the Musicbrainz instrument taxonomy, conforming to SKOS. This concept holds a seeAlso link 
		towards this taxonomy.  <br/>
     */
    public static final URI Instrument = new URIImpl("http://purl.org/ontology/mo/Instrument");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: instrumentation  <br/>
     * Comment: Instrumentation deals with the techniques of writing music for a specific instrument, 
		including the limitations of the instrument, playing techniques and idiomatic handling of the instrument.  <br/>
     */
    public static final URI Instrumentation = new URIImpl("http://purl.org/ontology/mo/Instrumentation");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: label  <br/>
     * Comment: Trade name of a company that produces musical works or expression of musical works.  <br/>
     */
    public static final URI Label = new URIImpl("http://purl.org/ontology/mo/Label");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: libretto  <br/>
     * Comment: Libretto  <br/>
     */
    public static final URI Libretto = new URIImpl("http://purl.org/ontology/mo/Libretto");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: listened  <br/>
     */
    public static final URI Listener = new URIImpl("http://purl.org/ontology/mo/Listener");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: lyrics  <br/>
     * Comment: Lyrics  <br/>
     */
    public static final URI Lyrics = new URIImpl("http://purl.org/ontology/mo/Lyrics");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: MD  <br/>
     * Comment: Mini Disc used as medium to record a musical manifestation.  <br/>
     */
    public static final URI MD = new URIImpl("http://purl.org/ontology/mo/MD");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: MagneticTape  <br/>
     * Comment: Magnetic analogue tape used as medium to record a musical manifestation.  <br/>
     */
    public static final URI MagneticTape = new URIImpl("http://purl.org/ontology/mo/MagneticTape");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Medium  <br/>
     * Comment: A means or instrumentality for storing or communicating musical manifestation.  <br/>
     */
    public static final URI Medium = new URIImpl("http://purl.org/ontology/mo/Medium");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: membership  <br/>
     * Comment: A membership event, where one or several people belongs to a group during a particular time period.  <br/>
     */
    public static final URI Membership = new URIImpl("http://purl.org/ontology/mo/Membership");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: movement  <br/>
     * Comment: A movement is a self-contained part of a musical work. While individual or selected movements from a composition are sometimes performed separately, a performance of the complete work requires all the movements to be performed in succession.

Often a composer attempts to interrelate the movements thematically, or sometimes in more subtle ways, in order that the individual
movements exert a cumulative effect. In some forms, composers sometimes link the movements, or ask for them to be played without a
pause between them.  <br/>
     */
    public static final URI Movement = new URIImpl("http://purl.org/ontology/mo/Movement");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: music artist  <br/>
     * Comment: A person or a group of people (or a computer :-) ), whose musical 
		creative work shows sensitivity and imagination  <br/>
     */
    public static final URI MusicArtist = new URIImpl("http://purl.org/ontology/mo/MusicArtist");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: music group  <br/>
     * Comment: Group of musicians, or musical ensemble, usually popular or folk, playing parts of or improvising off of a musical arrangement.  <br/>
     */
    public static final URI MusicGroup = new URIImpl("http://purl.org/ontology/mo/MusicGroup");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: musical expression  <br/>
     * Comment: The intellectual or artistic realization of a work in the form of alpha-numeric, musical, or choreographic notation, sound, etc., or any combination of such forms.    


For example:

Work #1 Franz Schubert's Trout quintet

    * Expression #1 the composer's score
    * Expression #2 sound issued from the performance by the Amadeus Quartet and Hephzibah Menuhin on piano
    * Expression #3 sound issued from the performance by the Cleveland Quartet and Yo-Yo Ma on the cello
    * . . . . 

The Music Ontology defines the following sub-concepts of a MusicalExpression, which should be used instead of MusicalExpression itself: Score (the
result of an arrangement), Sound (produced during a performance), Signal. However, it is possible to stick to FRBR and bypass the worflow
mechanism this ontology defines by using the core FRBR properties on such objects. But it is often better to use events to interconnect such 
expressions (allowing to go deeply into the production process - `this performer was playing this particular instrument at that
particular time').  <br/>
     */
    public static final URI MusicalExpression = new URIImpl("http://purl.org/ontology/mo/MusicalExpression");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: MusicalItem  <br/>
     * Comment: A single exemplar of a musical expression.
    
For example, it could be a single exemplar of a CD. This is normally an single object (a CD) possessed by somebody.

From the FRBR final report: The entity defined as item is a concrete entity. It is in many instances a single physical object (e.g., a copy of a one-volume monograph, a single audio cassette, etc.). There are instances, however, where the entity defined as item comprises more than one physical object (e.g., a monograph issued as two separately bound volumes, a recording issued on three separate compact discs, etc.).

In terms of intellectual content and physical form, an item exemplifying a manifestation is normally the same as the manifestation itself. However, variations may occur from one item to another, even when the items exemplify the same manifestation, where those variations are the result of actions external to the intent of the producer of the manifestation (e.g., damage occurring after the item was produced, binding performed by a library, etc.).  <br/>
     */
    public static final URI MusicalItem = new URIImpl("http://purl.org/ontology/mo/MusicalItem");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: musical manifestation  <br/>
     * Comment: This entity is related to the edition/production/publication of a musical expression (musical manifestation are closely related with the music industry (their terms, concepts, definitions, methods (production, publication, etc.), etc.)
    
From the FRBR final report: The entity defined as manifestation encompasses a wide range of materials, including manuscripts, books, periodicals, maps, posters, sound recordings, films, video recordings, CD-ROMs, multimedia kits, etc. As an entity, manifestation represents all the physical objects that bear the same characteristics, in respect to both intellectual content and physical form.


Work #1 J. S. Bach's Six suites for unaccompanied cello

    * Expression #1 sound issued during the performance by Janos Starker recorded in 1963 and 1965
          o Manifestation #1 recordings released on 33 1/3 rpm sound discs in 1965 by Mercury
          o Manifestation #2 recordings re-released on compact disc in 1991 by Mercury 
    * Expression #2 sound issued during the performances by Yo-Yo Ma recorded in 1983
          o Manifestation #1 recordings released on 33 1/3 rpm sound discs in 1983 by CBS Records
          o Manifestation #2 recordings re-released on compact disc in 1992 by CBS Records 

          
Changes that occur deliberately or even inadvertently in the production process that affect the copies result, strictly speaking, in a new manifestation. A manifestation resulting from such a change may be identified as a particular "state" or "issue" of the publication.

Changes that occur to an individual copy after the production process is complete (e.g., the loss of a page, rebinding, etc.) are not considered to result in a new manifestation. That copy is simply considered to be an exemplar (or item) of the manifestation that deviates from the copy as produced.

With the entity defined as manifestation we can describe the physical characteristics of a set of items and the characteristics associated with the production and distribution of that set of items that may be important factors in enabling users to choose a manifestation appropriate to their physical needs and constraints, and to identify and acquire a copy of that manifestation.

Defining manifestation as an entity also enables us to draw relationships between specific manifestations of a work. We can use the relationships between manifestations to identify, for example, the specific publication that was used to create a microreproduction.  <br/>
     */
    public static final URI MusicalManifestation = new URIImpl("http://purl.org/ontology/mo/MusicalManifestation");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: musical work  <br/>
     * Comment: Distinct intellectual or artistic musical creation.
    
From the FRBR final report: A work is an abstract entity; there is no single material object one can point to as the work. We recognize the work through individual realizations or expressions of the work, but the work itself exists only in the commonality of
content between and among the various expressions of the work. When we speak of Homer's Iliad as a work, our point of reference is not a particular recitation or text of the work, but the intellectual creation that lies behind all the various expressions of the work.     

For example:

work #1 J. S. Bach's The art of the fugue  <br/>
     */
    public static final URI MusicalWork = new URIImpl("http://purl.org/ontology/mo/MusicalWork");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: orchestration  <br/>
     * Comment: Orchestration includes, in addition to instrumentation, the handling of groups of instruments and their balance and interaction.  <br/>
     */
    public static final URI Orchestration = new URIImpl("http://purl.org/ontology/mo/Orchestration");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: performance  <br/>
     * Comment: A performance event. 
		It might include as agents performers, engineers, conductors, or even listeners.
		It might include as factors a score, a MusicalWork, musical instruments. 
		It might produce a sound:-)  <br/>
     */
    public static final URI Performance = new URIImpl("http://purl.org/ontology/mo/Performance");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: performer  <br/>
     */
    public static final URI Performer = new URIImpl("http://purl.org/ontology/mo/Performer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: published libretto  <br/>
     * Comment: A published libretto  <br/>
     */
    public static final URI PublishedLibretto = new URIImpl("http://purl.org/ontology/mo/PublishedLibretto");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: published lyrics  <br/>
     * Comment: Published lyrics, as a book or as a text file, for example  <br/>
     */
    public static final URI PublishedLyrics = new URIImpl("http://purl.org/ontology/mo/PublishedLyrics");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: published score  <br/>
     * Comment: A published score (subclass of MusicalManifestation)  <br/>
     */
    public static final URI PublishedScore = new URIImpl("http://purl.org/ontology/mo/PublishedScore");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: record  <br/>
     * Comment: A published record (manifestation which first aim is to render the product of a recording)  <br/>
     */
    public static final URI Record = new URIImpl("http://purl.org/ontology/mo/Record");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: recording  <br/>
     * Comment: A recording event.
		Takes a sound as a factor to produce a signal (analog or digital).
		The location of such events (if any) is the actual location of the corresponding
		microphone or the "recording device".  <br/>
     */
    public static final URI Recording = new URIImpl("http://purl.org/ontology/mo/Recording");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: recording session  <br/>
     * Comment: A set of performances/recordings/mastering events. This event can be decomposed in its constituent events using event:sub_event  <br/>
     */
    public static final URI RecordingSession = new URIImpl("http://purl.org/ontology/mo/RecordingSession");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: release  <br/>
     * Comment: A specific release, with barcode, box, liner notes, cover art, and a number of records  <br/>
     */
    public static final URI Release = new URIImpl("http://purl.org/ontology/mo/Release");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: release event  <br/>
     * Comment: A release event, in a particular place (e.g. a country) at a particular time. Other factors of this event might include cover art, liner notes, box, etc. or a release grouping all these.  <br/>
     */
    public static final URI ReleaseEvent = new URIImpl("http://purl.org/ontology/mo/ReleaseEvent");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: release status  <br/>
     * Comment: Musical manifestation release status.  <br/>
     */
    public static final URI ReleaseStatus = new URIImpl("http://purl.org/ontology/mo/ReleaseStatus");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Release type  <br/>
     * Comment: Release type of a particular manifestation, such as "album" or "interview"...  <br/>
     */
    public static final URI ReleaseType = new URIImpl("http://purl.org/ontology/mo/ReleaseType");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: SACD  <br/>
     * Comment: Super Audio Compact Disc used as medium to record a musical manifestation.  <br/>
     */
    public static final URI SACD = new URIImpl("http://purl.org/ontology/mo/SACD");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: score  <br/>
     * Comment: Here, we are dealing with the informational object (the MusicalExpression), not the actually "published" score.
		This may be, for example, the product of an arrangement process.  <br/>
     */
    public static final URI Score = new URIImpl("http://purl.org/ontology/mo/Score");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Show  <br/>
     * Comment: A show - a musical event lasting several days, in a particular venue. Examples can be
		"The Magic Flute" at the Opera Bastille, August 2005, or a musical in the west end...  <br/>
     */
    public static final URI Show = new URIImpl("http://purl.org/ontology/mo/Show");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: signal  <br/>
     * Comment: A subclass of MusicalExpression, representing a signal, for example a master signal produced by a performance and a recording.  <br/>
     */
    public static final URI Signal = new URIImpl("http://purl.org/ontology/mo/Signal");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: signal group  <br/>
     * Comment: A musical expression representing a group of signals, for example a set of masters resulting from a whole recording/mastering session.  <br/>
     */
    public static final URI SignalGroup = new URIImpl("http://purl.org/ontology/mo/SignalGroup");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: solo music artist  <br/>
     * Comment: Single person whose musical creative work shows sensitivity and imagination.  <br/>
     */
    public static final URI SoloMusicArtist = new URIImpl("http://purl.org/ontology/mo/SoloMusicArtist");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: sound  <br/>
     * Comment: A subclass of MusicalExpression, representing a sound. Realisation of a MusicalWork during a musical Performance.  <br/>
     */
    public static final URI Sound = new URIImpl("http://purl.org/ontology/mo/Sound");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: sound engineer  <br/>
     */
    public static final URI SoundEngineer = new URIImpl("http://purl.org/ontology/mo/SoundEngineer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Stream  <br/>
     * Comment: Transmission over a network  used as medium to broadcast a musical manifestation  <br/>
     */
    public static final URI Stream = new URIImpl("http://purl.org/ontology/mo/Stream");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Torrent  <br/>
     * Comment: Something available on the Bittorrent peer-2-peer filesharing network  <br/>
     */
    public static final URI Torrent = new URIImpl("http://purl.org/ontology/mo/Torrent");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: rack  <br/>
     * Comment: A track on a particular record  <br/>
     */
    public static final URI Track = new URIImpl("http://purl.org/ontology/mo/Track");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: transcription  <br/>
     * Comment: Transcription event  <br/>
     */
    public static final URI Transcription = new URIImpl("http://purl.org/ontology/mo/Transcription");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: Vinyl  <br/>
     * Comment: Vinyl used as medium to record a musical manifestation  <br/>
     */
    public static final URI Vinyl = new URIImpl("http://purl.org/ontology/mo/Vinyl");
    /**
     * Type: Instance of http://purl.org/ontology/mo/ReleaseStatus <br/>
     */
    public static final URI bootleg = new URIImpl("http://purl.org/ontology/mo/bootleg");
    /**
     * Type: Instance of http://purl.org/ontology/mo/ReleaseStatus <br/>
     */
    public static final URI official = new URIImpl("http://purl.org/ontology/mo/official");
    /**
     * Type: Instance of http://purl.org/ontology/mo/ReleaseStatus <br/>
     */
    public static final URI promotion = new URIImpl("http://purl.org/ontology/mo/promotion");
    /**
     * Type: Instance of http://purl.org/ontology/mo/ReleaseType <br/>
     */
    public static final URI album = new URIImpl("http://purl.org/ontology/mo/album");
    /**
     * Type: Instance of http://purl.org/ontology/mo/ReleaseType <br/>
     */
    public static final URI audiobook = new URIImpl("http://purl.org/ontology/mo/audiobook");
    /**
     * Type: Instance of http://purl.org/ontology/mo/ReleaseType <br/>
     */
    public static final URI compilation = new URIImpl("http://purl.org/ontology/mo/compilation");
    /**
     * Type: Instance of http://purl.org/ontology/mo/ReleaseType <br/>
     */
    public static final URI ep = new URIImpl("http://purl.org/ontology/mo/ep");
    /**
     * Type: Instance of http://purl.org/ontology/mo/ReleaseType <br/>
     */
    public static final URI interview = new URIImpl("http://purl.org/ontology/mo/interview");
    /**
     * Type: Instance of http://purl.org/ontology/mo/ReleaseType <br/>
     */
    public static final URI live = new URIImpl("http://purl.org/ontology/mo/live");
    /**
     * Type: Instance of http://purl.org/ontology/mo/ReleaseType <br/>
     */
    public static final URI remix = new URIImpl("http://purl.org/ontology/mo/remix");
    /**
     * Type: Instance of http://purl.org/ontology/mo/ReleaseType <br/>
     */
    public static final URI soundtrack = new URIImpl("http://purl.org/ontology/mo/soundtrack");
    /**
     * Type: Instance of http://purl.org/ontology/mo/ReleaseType <br/>
     */
    public static final URI spokenword = new URIImpl("http://purl.org/ontology/mo/spokenword");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#FunctionalProperty <br/>
     * Comment: Associates a digital signal to the number a bits used to encode one sample. Range is xsd:int.  <br/>
     * Domain: http://purl.org/ontology/mo/DigitalSignal  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#int  <br/>
     */
    public static final URI bitsPerSample = new URIImpl("http://purl.org/ontology/mo/bitsPerSample");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: bpm  <br/>
     * Comment: Indicates the BPM of a MusicalWork or a particular Performance 
		Beats per minute: the pace of music measured by the number of beats occurring in 60 seconds.  <br/>
     * Domain: _:node15g3vghdfx12  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#float  <br/>
     */
    public static final URI bpm = new URIImpl("http://purl.org/ontology/mo/bpm");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: catalogue number  <br/>
     * Comment: Links a release with the corresponding catalogue number  <br/>
     * Domain: http://purl.org/ontology/mo/Release  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI catalogue_number = new URIImpl("http://purl.org/ontology/mo/catalogue_number");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#FunctionalProperty <br/>
     * Comment: Associates a signal to the number of channels it holds (mono --> 1, stereo --> 2). Range is xsd:int.  <br/>
     * Domain: http://purl.org/ontology/mo/Signal  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#int  <br/>
     */
    public static final URI channels = new URIImpl("http://purl.org/ontology/mo/channels");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: ean  <br/>
     * Comment: The European Article Number (EAN) is a universal identifier for products, commonly printed in form of barcodes on them. The numbers represented by those codes can either be 8 or 13 digits long, with the 13-digit-version being most common. EANs form a superset of the North American Universal Product Code (UPC) as every UPC can be made an EAN by adding a leading zero to it. Additionally every EAN is also a Japanese Article Number (JAN). The identifiers were formerly assigned by EAN International which merged with Uniform Code Council (UCC, the guys behind the UPCs) and Electronic Commerce Council of Canada (ECCC) to become GS1.  <br/>
     * Domain: http://purl.org/ontology/mo/Release  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI ean = new URIImpl("http://purl.org/ontology/mo/ean");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: encoding  <br/>
     * Comment: Method used to convert analog electronic signals into digital format such as "MP3 CBR @ 128kbps", "OGG @ 160kbps", "FLAC", etc.  <br/>
     * Domain: http://purl.org/ontology/mo/AudioFile  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI encoding = new URIImpl("http://purl.org/ontology/mo/encoding");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: GRid  <br/>
     * Comment: The Global Release Identifier (GRid) is a system for uniquely identifying Releases of music over electronic networks (that is, online stores where you can buy music as digital files). As that it can be seen as the equivalent of the BarCode (or more correctly the GTIN) as found on physical releases of music. Like the ISRC (a code for identifying single recordings as found on releases) it was developed by the IFPI but it does not appear to be a standard of the ISO.  <br/>
     * Domain: http://purl.org/ontology/mo/Release  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI grid = new URIImpl("http://purl.org/ontology/mo/grid");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: gtin  <br/>
     * Comment: GTIN is a grouping term for EANs and UPCs. In common speech those are called barcodes although the barcodes are just a representation of those identifying numbers.  <br/>
     * Domain: http://purl.org/ontology/mo/Release  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI gtin = new URIImpl("http://purl.org/ontology/mo/gtin");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: ipi  <br/>
     * Comment: The Interested Parties Information Code (IPI) is an ISO standard similar to ISBNs for identifying the people or groups with some involvement with a particular musical work / compositions.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicArtist  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI ipi = new URIImpl("http://purl.org/ontology/mo/ipi");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: ismn  <br/>
     * Comment: The International Standard Music Number (ISMN) is an ISO standard similar to ISBNs for identifying printed music publications  <br/>
     * Domain: _:node15g3vghdfx70  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI ismn = new URIImpl("http://purl.org/ontology/mo/ismn");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: isrc  <br/>
     * Comment: The ISRC (International Standard Recording Code) is the international identification system for sound recordings and music videorecordings. 
	Each ISRC is a unique and permanent identifier for a specific recording which can be permanently encoded into a product as its digital fingerprint. 
	Encoded ISRC provide the means to automatically identify recordings for royalty payments.  <br/>
     * Domain: http://purl.org/ontology/mo/Signal  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI isrc = new URIImpl("http://purl.org/ontology/mo/isrc");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: iswc  <br/>
     * Comment: Links a musical work to the corresponding ISWC number  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalWork  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI iswc = new URIImpl("http://purl.org/ontology/mo/iswc");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: lc  <br/>
     * Comment: The Label Code (LC) was introduced in 1977 by the IFPI (International Federation of Phonogram and Videogram Industries) in order to unmistakably identify the different record labels (see Introduction, Record labels) for rights purposes. The Label Code consists historically of 4 figures, presently being extended to 5 figures, preceded by LC and a dash (e.g. LC-0193 = Electrola; LC-0233 = His Master's Voice). Note that the number of countries using the LC is limited, and that the code given on the item is not always accurate.  <br/>
     * Domain: http://purl.org/ontology/mo/Label  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI lc = new URIImpl("http://purl.org/ontology/mo/lc");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: meter  <br/>
     * Comment: Associates a musical work or a score with its meter  <br/>
     * Domain: _:node15g3vghdfx88  <br/>
     */
    public static final URI meter = new URIImpl("http://purl.org/ontology/mo/meter");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     */
    public static final URI movementNum = new URIImpl("http://purl.org/ontology/mo/movementNum");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: movement number  <br/>
     * Comment: Indicates the position of a movement in a musical work.  <br/>
     * Domain: http://purl.org/ontology/mo/Movement  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#int  <br/>
     */
    public static final URI movement_number = new URIImpl("http://purl.org/ontology/mo/movement_number");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: Musicbrainz GUID  <br/>
     * Comment: Links an object to the corresponding Musicbrainz identifier  <br/>
     * Domain: _:node15g3vghdfx96  <br/>
     */
    public static final URI musicbrainz_guid = new URIImpl("http://purl.org/ontology/mo/musicbrainz_guid");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: opus  <br/>
     * Comment: Used to define a creative work, especially a musical composition numbered to designate the order of a composer's works.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalWork  <br/>
     * Range: http://www.w3.org/2000/01/rdf-schema#Literal  <br/>
     */
    public static final URI opus = new URIImpl("http://purl.org/ontology/mo/opus");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: puid  <br/>
     * Comment: Link a signal to the PUIDs associated with it, that is, PUID computed from MusicalItems (mo:AudioFile) 
		derived from this signal.

		PUIDs (Portable Unique IDentifier) are the IDs used in the 
		proprietary MusicDNS AudioFingerprinting system which is operated by MusicIP.

		Using PUIDs, one (with some luck) can identify the Signal object associated with a particular audio file, therefore allowing
		to access further information (on which release this track is featured? etc.). Using some more metadata one can identify
		the particular Track corresponding to the audio file (a track on a particular release).  <br/>
     * Domain: http://purl.org/ontology/mo/Signal  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI puid = new URIImpl("http://purl.org/ontology/mo/puid");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: record count  <br/>
     * Comment: Associates a release with the number of records it contains, e.g. the number of discs it contains in the case of a multi-disc release.  <br/>
     * Domain: http://purl.org/ontology/mo/Release  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#int  <br/>
     */
    public static final URI record_count = new URIImpl("http://purl.org/ontology/mo/record_count");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: has record number@en  <br/>
     * Comment: Indicates the position of a record in a release (e.g. a 2xLP, etc.).@en  <br/>
     * Domain: http://purl.org/ontology/mo/Record  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#nonNegativeInteger  <br/>
     */
    public static final URI record_number = new URIImpl("http://purl.org/ontology/mo/record_number");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: has record side@en  <br/>
     * Comment: Associates the side on a vinyl record, where a track is located, e.g. A, B, C, etc. This property can then also be used 
in conjunction with mo:track_number, so that one can infer e.g. "A1", that means, track number 1 on side A.@en  <br/>
     * Domain: http://purl.org/ontology/mo/Track  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI record_side = new URIImpl("http://purl.org/ontology/mo/record_side");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     */
    public static final URI sampleRate = new URIImpl("http://purl.org/ontology/mo/sampleRate");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#FunctionalProperty <br/>
     * Comment: Associates a digital signal to its sample rate. It might be easier to express it this way instead of
		defining a timeline map:-) Range is xsd:float.  <br/>
     * Domain: http://purl.org/ontology/mo/DigitalSignal  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#float  <br/>
     */
    public static final URI sample_rate = new URIImpl("http://purl.org/ontology/mo/sample_rate");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: tempo  <br/>
     * Comment: Rate of speed or pace of music. Tempo markings are traditionally given in Italian; 
		common markings include: grave (solemn; very, very slow); largo (broad; very slow); 
		adagio (quite slow); andante (a walking pace); moderato (moderate); allegro (fast; cheerful); 
		vivace (lively); presto (very fast); accelerando (getting faster); ritardando (getting slower); 
		and a tempo (in time; returning to the original pace).  <br/>
     * Domain: _:node15g3vghdfx141  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI tempo = new URIImpl("http://purl.org/ontology/mo/tempo");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: text  <br/>
     * Comment: Associates lyrics with their text.  <br/>
     * Domain: http://purl.org/ontology/mo/Lyrics  <br/>
     */
    public static final URI text = new URIImpl("http://purl.org/ontology/mo/text");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     */
    public static final URI trackNum = new URIImpl("http://purl.org/ontology/mo/trackNum");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: track count  <br/>
     * Comment: The track count of a record  <br/>
     * Domain: http://purl.org/ontology/mo/Record  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#int  <br/>
     */
    public static final URI track_count = new URIImpl("http://purl.org/ontology/mo/track_count");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: track number  <br/>
     * Comment: Indicates the position of a track on a record medium (a CD, etc.).  <br/>
     * Domain: http://purl.org/ontology/mo/Track  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#nonNegativeInteger  <br/>
     */
    public static final URI track_number = new URIImpl("http://purl.org/ontology/mo/track_number");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: trmid  <br/>
     * Comment: Indicates the TRMID of a track.
		TRM IDs are MusicBrainz' old AudioFingerprinting system. 
		TRM (TRM Recognizes Music) IDs are (somewhat) unique ids that represent 
		the audio signature of a musical piece (see AudioFingerprint).  <br/>
     * Domain: http://purl.org/ontology/mo/Signal  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI trmid = new URIImpl("http://purl.org/ontology/mo/trmid");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: upc  <br/>
     * Comment: UPC stands for "Universal Product Code", which was the original barcode used in the United States and Canada. The UPC (now officially EAN.UCC-12 is a numerical method of identifying products without redundancy worldwide for all types of products in the retail sector. The EAN is a superset of the original UPC increasing the digits to 13 with the prefix 0 reserved for UPC. As of 2005, manufacturers are only allowed to use the new 13-digit codes on their items, rather than having two separate numbers.  <br/>
     * Domain: http://purl.org/ontology/mo/Release  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI upc = new URIImpl("http://purl.org/ontology/mo/upc");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: universally unique identifier  <br/>
     * Comment: Links an object to an universally unique identifier for it.  <br/>
     * Domain: http://www.w3.org/2002/07/owl#Thing  <br/>
     */
    public static final URI uuid = new URIImpl("http://purl.org/ontology/mo/uuid");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: amazon_asin  <br/>
     * Comment: Used to link a work or the expression of a work to its corresponding Amazon ASINs page.  <br/>
     * Domain: _:node15g3vghdfx7  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI amazon_asin = new URIImpl("http://purl.org/ontology/mo/amazon_asin");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: arranged in  <br/>
     * Comment: Associates a work to an arrangement event where it was arranged  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalWork  <br/>
     * Range: http://purl.org/ontology/mo/Arrangement  <br/>
     */
    public static final URI arranged_in = new URIImpl("http://purl.org/ontology/mo/arranged_in");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: arrangement of  <br/>
     * Comment: Associates an arrangement event to a work  <br/>
     * Domain: http://purl.org/ontology/mo/Arrangement  <br/>
     * Range: http://purl.org/ontology/mo/MusicalWork  <br/>
     */
    public static final URI arrangement_of = new URIImpl("http://purl.org/ontology/mo/arrangement_of");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI availableAs = new URIImpl("http://purl.org/ontology/mo/availableAs");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Comment: Relates a musical manifestation to a musical item (this album, and my particular cd). By using
		this property, there is no assumption on wether the full content is available on the linked item.
		To be explicit about this, you can use a sub-property, such as mo:item (the full manifestation
		is available on that item) or mo:preview (only a part of the manifestation is available on
		that item).

		This is a subproperty of frbr:examplar.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     * Range: http://purl.org/ontology/mo/MusicalItem  <br/>
     */
    public static final URI available_as = new URIImpl("http://purl.org/ontology/mo/available_as");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: biography  <br/>
     * Comment: Used to link an artist to their online biography.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicArtist  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI biography = new URIImpl("http://purl.org/ontology/mo/biography");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#SymmetricProperty <br/>
     * Label: collaborated_with  <br/>
     * Comment: Used to relate two collaborating people on a work.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI collaborated_with = new URIImpl("http://purl.org/ontology/mo/collaborated_with");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: compilation_of  <br/>
     * Comment: Indicates that a musical manifestation is a compilation of several Signals.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     * Range: http://purl.org/ontology/mo/Signal  <br/>
     */
    public static final URI compilation_of = new URIImpl("http://purl.org/ontology/mo/compilation_of");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: compiled  <br/>
     * Comment: Used to relate an person or a group of person who compiled the manifestation of a musical work.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicArtist  <br/>
     * Range: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     */
    public static final URI compiled = new URIImpl("http://purl.org/ontology/mo/compiled");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: compiler  <br/>
     * Comment: Used to relate the manifestation of a musical work to a person or a group of person who compiled it.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     * Range: http://purl.org/ontology/mo/MusicArtist  <br/>
     */
    public static final URI compiler = new URIImpl("http://purl.org/ontology/mo/compiler");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: composed in  <br/>
     * Comment: Associates a MusicalWork to the Composition event pertaining
		to its creation. For example, I might use this property to associate
		the Magic Flute to its composition event, occuring during 1782 and having as
		a mo:composer Mozart.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalWork  <br/>
     * Range: http://purl.org/ontology/mo/Composition  <br/>
     */
    public static final URI composed_in = new URIImpl("http://purl.org/ontology/mo/composed_in");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: composer  <br/>
     * Comment: Associates a composition event to the actual composer. For example,
		this property could link the event corresponding to the composition of the
		Magic Flute in 1782 to Mozart himself (who obviously has a FOAF profile:-) ).  <br/>
     * Domain: http://purl.org/ontology/mo/Composition  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI composer = new URIImpl("http://purl.org/ontology/mo/composer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: conducted  <br/>
     * Comment: Relates agents to the performances they were conducting  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://purl.org/ontology/mo/Performance  <br/>
     */
    public static final URI conducted = new URIImpl("http://purl.org/ontology/mo/conducted");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Comment: Relates a performance to the conductor involved  <br/>
     * Domain: http://purl.org/ontology/mo/Performance  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI conductor = new URIImpl("http://purl.org/ontology/mo/conductor");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: contains_sample_from  <br/>
     * Comment: Relates a signal to another signal, which has been sampled.  <br/>
     */
    public static final URI contains_sample_from = new URIImpl("http://purl.org/ontology/mo/contains_sample_from");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: derived from@en  <br/>
     * Comment: A related signal from which the described signal is derived.@en  <br/>
     * Domain: http://purl.org/ontology/mo/Signal  <br/>
     * Range: http://purl.org/ontology/mo/Signal  <br/>
     */
    public static final URI derived_from = new URIImpl("http://purl.org/ontology/mo/derived_from");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: discography  <br/>
     * Comment: Used to links an artist to an online discography of their musical works. The discography should provide a summary of each released musical work of the artist.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicArtist  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI discography = new URIImpl("http://purl.org/ontology/mo/discography");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: discogs  <br/>
     * Comment: Used to link a musical work or the expression of a musical work, an artist or a corporate body to to its corresponding Discogs page.  <br/>
     * Domain: _:node15g3vghdfx16  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI discogs = new URIImpl("http://purl.org/ontology/mo/discogs");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: djmix_of  <br/>
     * Comment: Indicates that all (or most of) the tracks of a musical work or the expression of a musical work were mixed together from all (or most of) the tracks from another musical work or the expression of a musical work to form a so called DJ-Mix. 
    
The tracks might have been altered by pitching (so that the tempo of one track matches the tempo of the following track) and fading (so that one track blends in smoothly with the other). If the tracks have been more substantially altered, the "mo:remix" relationship type is more appropriate.  <br/>
     */
    public static final URI djmix_of = new URIImpl("http://purl.org/ontology/mo/djmix_of");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: djmixed  <br/>
     * Comment: Used to relate an artist who djmixed a musical work or the expression of a musical work. 
    
The artist usually selected the tracks, chose their sequence, and slightly changed them by fading (so that one track blends in smoothly with the other) or pitching (so that the tempo of one track matches the tempo of the following track). This applies to a 'Mixtape' in which all tracks were DJ-mixed together into one single long track.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicArtist  <br/>
     * Range: http://purl.org/ontology/mo/Signal  <br/>
     */
    public static final URI djmixed = new URIImpl("http://purl.org/ontology/mo/djmixed");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: djmixed_by  <br/>
     * Comment: Used to relate a work or the expression of a work to an artist who djmixed it. 
    
The artist usually selected the tracks, chose their sequence, and slightly changed them by fading (so that one track blends in smoothly with the other) or pitching (so that the tempo of one track matches the tempo of the following track). This applies to a 'Mixtape' in which all tracks were DJ-mixed together into one single long track.  <br/>
     * Domain: http://purl.org/ontology/mo/Signal  <br/>
     * Range: http://purl.org/ontology/mo/MusicArtist  <br/>
     */
    public static final URI djmixed_by = new URIImpl("http://purl.org/ontology/mo/djmixed_by");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: download  <br/>
     * Comment: This property can be used to link from a person to the website where they make their works available, or from
                a manifestation (a track or an album, for example) to a web page where it is available for
                download.
		
		It is better to use one of the three sub-properties instead of this one in order to specify wether the
		content can be accessed for free (mo:freedownload), if it is just free preview material (mo:previewdownload), or
		if it can be accessed for some money (mo:paiddownload) (this includes links to the Amazon store, for example).

                This property MUST be used only if the content is just available through a web page (holding, for example
                a Flash application) - it is better to link to actual content directly through the use of mo:available_as and
                mo:Stream, mo:Torrent or mo:ED2K, etc. Therefore, Semantic Web user agents that don't know how to read HTML and even
                less to rip streams from Flash applications can still access the audio content.  <br/>
     * Domain: _:node15g3vghdfx22  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI download = new URIImpl("http://purl.org/ontology/mo/download");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: encodes  <br/>
     * Comment: Relates a MusicalItem (a track on a particular CD, an audio file, a stream somewhere) to the signal it encodes.

		This is usually a lower-resolution version of the master signal (issued from a Recording event).  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalItem  <br/>
     * Range: http://purl.org/ontology/mo/Signal  <br/>
     */
    public static final URI encodes = new URIImpl("http://purl.org/ontology/mo/encodes");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Comment: Relates a performance or a recording to the engineer involved  <br/>
     * Domain: _:node15g3vghdfx26  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI engineer = new URIImpl("http://purl.org/ontology/mo/engineer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: engineered  <br/>
     * Comment: Relates agents to the performances/recordings they were engineering in  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: _:node15g3vghdfx30  <br/>
     */
    public static final URI engineered = new URIImpl("http://purl.org/ontology/mo/engineered");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI eventHomePage = new URIImpl("http://purl.org/ontology/mo/eventHomePage");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: event homepage  <br/>
     * Comment: Links a particular event to a web page  <br/>
     * Domain: http://purl.org/NET/c4dm/event.owl#Event  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI event_homepage = new URIImpl("http://purl.org/ontology/mo/event_homepage");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: exchange_item  <br/>
     * Comment: A person, a group of person or an organization exchanging an exemplar of a single manifestation.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://purl.org/vocab/frbr/core#Item  <br/>
     */
    public static final URI exchange_item = new URIImpl("http://purl.org/ontology/mo/exchange_item");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: fanpage  <br/>
     * Comment: Used to link an artist to a fan-created webpage devoted to that artist.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicArtist  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI fanpage = new URIImpl("http://purl.org/ontology/mo/fanpage");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: free download  <br/>
     * Comment: This property can be used to link from a person to the website where they make their works available, or from
		a manifestation (a track or an album, for example) to a web page where it is available for free 
		download.

		This property MUST be used only if the content is just available through a web page (holding, for example
		a Flash application) - it is better to link to actual content directly through the use of mo:available_as and 
		mo:Stream, mo:Torrent or mo:ED2K, etc. Therefore, Semantic Web user agents that don't know how to read HTML and even
		less to rip streams from Flash applications can still access the audio content.  <br/>
     * Domain: _:node15g3vghdfx34  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI free_download = new URIImpl("http://purl.org/ontology/mo/free_download");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI freedownload = new URIImpl("http://purl.org/ontology/mo/freedownload");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: genre  <br/>
     * Comment: Associates an event (like a performance or a recording) to a particular musical genre.
		Further version of this property may also include works and scores in the domain.  <br/>
     * Domain: _:node15g3vghdfx38  <br/>
     * Range: http://purl.org/ontology/mo/Genre  <br/>
     */
    public static final URI genre = new URIImpl("http://purl.org/ontology/mo/genre");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: group  <br/>
     * Comment: Relates a membership event with the corresponding group  <br/>
     * Domain: http://purl.org/ontology/mo/Membership  <br/>
     * Range: http://xmlns.com/foaf/0.1/Group  <br/>
     */
    public static final URI group = new URIImpl("http://purl.org/ontology/mo/group");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI has_track = new URIImpl("http://purl.org/ontology/mo/has_track");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: headliner^^http://www.w3.org/2001/XMLSchema#string  <br/>
     * Comment: Relates a performance to the headliner(s) involved^^http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI headliner = new URIImpl("http://purl.org/ontology/mo/headliner");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: homepage  <br/>
     * Comment: Links an artist, a record, etc. to a corresponding web page  <br/>
     * Domain: _:node15g3vghdfx49  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI homepage = new URIImpl("http://purl.org/ontology/mo/homepage");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: image  <br/>
     * Comment: Indicates a pictorial image (JPEG, GIF, PNG, Etc.) of a musical work, the expression of a musical work, the manifestation of a work or the examplar of a manifestation.  <br/>
     * Domain: _:node15g3vghdfx55  <br/>
     * Range: http://xmlns.com/foaf/0.1/Image  <br/>
     */
    public static final URI image = new URIImpl("http://purl.org/ontology/mo/image");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: imdb  <br/>
     * Comment: Used to link an artist, a musical work or the expression of a musical work to their equivalent page on IMDb, the InternetMovieDatabase.  <br/>
     * Domain: _:node15g3vghdfx61  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI imdb = new URIImpl("http://purl.org/ontology/mo/imdb");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Comment: Relates a performance to a musical instrument involved  <br/>
     * Domain: _:node15g3vghdfx67  <br/>
     * Range: http://purl.org/ontology/mo/Instrument  <br/>
     */
    public static final URI instrument = new URIImpl("http://purl.org/ontology/mo/instrument");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: has interpeter@en  <br/>
     * Comment: Adds an involved music artist, who interpreted, remixed, or otherwise modified an existing signal, which resulted in the signal that is here the subject of this relation.@en  <br/>
     * Domain: http://purl.org/ontology/mo/Signal  <br/>
     * Range: http://purl.org/ontology/mo/MusicArtist  <br/>
     */
    public static final URI interpreter = new URIImpl("http://purl.org/ontology/mo/interpreter");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Comment: Relates a musical manifestation to a musical item (this album, and my particular cd) holding the
		entire manifestation, and not just a part of it.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     * Range: http://purl.org/ontology/mo/MusicalItem  <br/>
     */
    public static final URI item = new URIImpl("http://purl.org/ontology/mo/item");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: key  <br/>
     * Comment: Indicated the key used by the musicians during a performance, or the key of a MusicalWork.
		Any of 24 major or minor diatonic scales that provide the tonal framework for a piece of music.  <br/>
     * Domain: _:node15g3vghdfx74  <br/>
     * Range: http://purl.org/NET/c4dm/keys.owl#Key  <br/>
     */
    public static final URI key = new URIImpl("http://purl.org/ontology/mo/key");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: label  <br/>
     * Comment: Associates a release event with the label releasing the record  <br/>
     * Domain: _:node15g3vghdfx77  <br/>
     * Range: http://purl.org/ontology/mo/Label  <br/>
     */
    public static final URI label = new URIImpl("http://purl.org/ontology/mo/label");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: licence  <br/>
     * Comment: Used to link a work or the expression of a work to the license under which they can be manipulated (downloaded, modified, etc). 
    
This is usually used to link to a Creative Commons licence.  <br/>
     * Domain: _:node15g3vghdfx80  <br/>
     * Range: http://web.resource.org/cc/License  <br/>
     */
    public static final URI licence = new URIImpl("http://purl.org/ontology/mo/licence");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: listened  <br/>
     * Comment: Relates agents to the performances they were listening in  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://purl.org/ontology/mo/Performance  <br/>
     */
    public static final URI listened = new URIImpl("http://purl.org/ontology/mo/listened");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Comment: Relates a performance to the listener involved  <br/>
     * Domain: http://purl.org/ontology/mo/Performance  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI listener = new URIImpl("http://purl.org/ontology/mo/listener");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: mailorder  <br/>
     * Comment: Used to link a musical work or the expression of a musical work to a website where people can buy a copy of the musical manifestation.  <br/>
     * Domain: _:node15g3vghdfx84  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI mailorder = new URIImpl("http://purl.org/ontology/mo/mailorder");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: mashup_of  <br/>
     * Comment: Indicates that musical works or the expressions of a musical work were mashed up on this album or track. 
    
This means that two musical works or the expressions of a musical work by different artists are mixed together, over each other, or otherwise combined into a single musical work (usually by a third artist, the remixer).  <br/>
     */
    public static final URI mashup_of = new URIImpl("http://purl.org/ontology/mo/mashup_of");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: has media type@en  <br/>
     * Comment: The mediatype (file format or MIME type, or physical medium) of a musical manifestation, e.g. a MP3, CD or vinyl.@en  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     * Range: http://purl.org/dc/terms/MediaType  <br/>
     */
    public static final URI media_type = new URIImpl("http://purl.org/ontology/mo/media_type");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: medley_of  <br/>
     * Comment: Indicates that a musical expression is a medley of several other musical expressions. 
    
This means that the orignial musical expression were rearranged to create a new musical expression in the form of a medley.  <br/>
     */
    public static final URI medley_of = new URIImpl("http://purl.org/ontology/mo/medley_of");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: member  <br/>
     * Comment: Indicates a member of a musical group  <br/>
     * Domain: http://purl.org/ontology/mo/MusicGroup  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI member = new URIImpl("http://purl.org/ontology/mo/member");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: member_of  <br/>
     * Comment: Inverse of the foaf:member property  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://xmlns.com/foaf/0.1/Group  <br/>
     */
    public static final URI member_of = new URIImpl("http://purl.org/ontology/mo/member_of");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: membership  <br/>
     * Comment: Relates an agent with related membership events  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://purl.org/ontology/mo/Membership  <br/>
     */
    public static final URI membership = new URIImpl("http://purl.org/ontology/mo/membership");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: has_movement  <br/>
     * Comment: Indicates that a musical work has movements  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalWork  <br/>
     * Range: http://purl.org/ontology/mo/Movement  <br/>
     */
    public static final URI movement = new URIImpl("http://purl.org/ontology/mo/movement");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: musicbrainz  <br/>
     * Comment: Linking an agent, a track or a record to its corresponding Musicbrainz page.  <br/>
     * Domain: _:node15g3vghdfx91  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI musicbrainz = new URIImpl("http://purl.org/ontology/mo/musicbrainz");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: musicmoz  <br/>
     * Comment: Used to link an artist, a musical work or the expression of a musical work to its corresponding MusicMoz page.  <br/>
     * Domain: _:node15g3vghdfx104  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI musicmoz = new URIImpl("http://purl.org/ontology/mo/musicmoz");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: myspace  <br/>
     * Comment: Used to link a person to its corresponding MySpace page.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI myspace = new URIImpl("http://purl.org/ontology/mo/myspace");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: olga  <br/>
     * Comment: Used to link a track to a tabulature file for track in the On-Line Guitar Archive.  <br/>
     * Domain: http://purl.org/ontology/mo/Track  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI olga = new URIImpl("http://purl.org/ontology/mo/olga");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: onlinecommunity  <br/>
     * Comment: Used to link a person with an online community web page like a blog, a wiki, a forum, a livejournal page, Etc.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI onlinecommunity = new URIImpl("http://purl.org/ontology/mo/onlinecommunity");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#SymmetricProperty <br/>
     * Label: other_release_of  <br/>
     * Comment: Indicates that two musical manifestations are essentially the same.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     * Range: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     */
    public static final URI other_release_of = new URIImpl("http://purl.org/ontology/mo/other_release_of");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: paid download  <br/>
     * Comment: Provide a link from an artist to a web page where all of that artist's musical work is available for some money,
                or a link from a manifestation (record/track, for example) to a web page providing a paid access to this manifestation.  <br/>
     * Domain: _:node15g3vghdfx109  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI paid_download = new URIImpl("http://purl.org/ontology/mo/paid_download");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI paiddownload = new URIImpl("http://purl.org/ontology/mo/paiddownload");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: performance of  <br/>
     * Comment: Associates a Performance to a musical work or an arrangement that is being used as a factor in it.
		For example, I might use this property to attach the Magic Flute musical work to 
		a particular Performance.  <br/>
     * Domain: http://purl.org/ontology/mo/Performance  <br/>
     * Range: _:node15g3vghdfx113  <br/>
     */
    public static final URI performance_of = new URIImpl("http://purl.org/ontology/mo/performance_of");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: performed  <br/>
     * Comment: Relates agents to the performances they were performing in  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://purl.org/ontology/mo/Performance  <br/>
     */
    public static final URI performed = new URIImpl("http://purl.org/ontology/mo/performed");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: performed in  <br/>
     * Comment: Associates a Musical Work or an Score to Performances in which they were
		a factor. For example, I might use this property in order to 
		associate the Magic Flute to a particular performance at the Opera
		Bastille last year.  <br/>
     * Domain: _:node15g3vghdfx116  <br/>
     * Range: http://purl.org/ontology/mo/Performance  <br/>
     */
    public static final URI performed_in = new URIImpl("http://purl.org/ontology/mo/performed_in");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Comment: Relates a performance to the performers involved  <br/>
     * Domain: http://purl.org/ontology/mo/Performance  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI performer = new URIImpl("http://purl.org/ontology/mo/performer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: possess_item  <br/>
     * Comment: A person, a group of person or an organization possessing an exemplar of a single manifestation.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://purl.org/vocab/frbr/core#Item  <br/>
     */
    public static final URI possess_item = new URIImpl("http://purl.org/ontology/mo/possess_item");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Comment: Relates a musical manifestation to a musical item (this album, and my particular cd), which holds
		a preview of the manifestation (eg. one track for an album, or a snippet for a track)  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     * Range: http://purl.org/ontology/mo/MusicalItem  <br/>
     */
    public static final URI preview = new URIImpl("http://purl.org/ontology/mo/preview");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: preview download  <br/>
     * Comment: This property can be used to link from a person to the website where they make previews of their works available, or from
                a manifestation (a track or an album, for example) to a web page where a preview download is available.

                This property MUST be used only if the content is just available through a web page (holding, for example
                a Flash application) - it is better to link to actual content directly through the use of mo:available_as and
                mo:Stream, mo:Torrent or mo:ED2K, etc. Therefore, Semantic Web user agents that don't know how to read HTML and even
                less to rip streams from Flash applications can still access the audio content.  <br/>
     * Domain: _:node15g3vghdfx119  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI preview_download = new URIImpl("http://purl.org/ontology/mo/preview_download");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: primary instrument  <br/>
     * Comment: Indicates that a member was primarily playing a particular instrument during his membership  <br/>
     * Domain: http://purl.org/ontology/mo/Membership  <br/>
     * Range: http://purl.org/ontology/mo/Instrument  <br/>
     */
    public static final URI primary_instrument = new URIImpl("http://purl.org/ontology/mo/primary_instrument");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: produced  <br/>
     * Comment: Used to relate an person or a group of person who produced the manifestation of a work.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     */
    public static final URI produced = new URIImpl("http://purl.org/ontology/mo/produced");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: produced score  <br/>
     * Comment: Associates an arrangement event to a score product (score here does not refer to a published score, but more
		an abstract arrangement of a particular work).  <br/>
     * Domain: http://purl.org/ontology/mo/Arrangement  <br/>
     * Range: http://purl.org/ontology/mo/Score  <br/>
     */
    public static final URI produced_score = new URIImpl("http://purl.org/ontology/mo/produced_score");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: produced signal  <br/>
     * Comment: Associates a Recording to the outputted signal.  <br/>
     * Domain: http://purl.org/ontology/mo/Recording  <br/>
     * Range: http://purl.org/ontology/mo/Signal  <br/>
     */
    public static final URI produced_signal = new URIImpl("http://purl.org/ontology/mo/produced_signal");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: produced signal group  <br/>
     * Comment: Associates a recording session with a group of master signals produced by it.  <br/>
     * Domain: http://purl.org/ontology/mo/RecordingSession  <br/>
     * Range: http://purl.org/ontology/mo/SignalGroup  <br/>
     */
    public static final URI produced_signal_group = new URIImpl("http://purl.org/ontology/mo/produced_signal_group");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: produced sound  <br/>
     * Comment: Associates a Performance to a physical Sound that is being produced by it.  <br/>
     * Domain: http://purl.org/ontology/mo/Performance  <br/>
     * Range: http://purl.org/ontology/mo/Sound  <br/>
     */
    public static final URI produced_sound = new URIImpl("http://purl.org/ontology/mo/produced_sound");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: produced work  <br/>
     * Comment: Associates a composition event to the produced MusicalWork. For example,
                this property could link the event corresponding to the composition of the
                Magic Flute in 1782 to the Magic Flute musical work itself. This musical work
		can then be used in particular performances.  <br/>
     * Domain: http://purl.org/ontology/mo/Composition  <br/>
     * Range: http://purl.org/ontology/mo/MusicalWork  <br/>
     */
    public static final URI produced_work = new URIImpl("http://purl.org/ontology/mo/produced_work");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: producer  <br/>
     * Comment: Used to relate the manifestation of a work to a person or a group of person who produced it.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI producer = new URIImpl("http://purl.org/ontology/mo/producer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI producesSignal = new URIImpl("http://purl.org/ontology/mo/producesSignal");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI producesSound = new URIImpl("http://purl.org/ontology/mo/producesSound");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI producesWork = new URIImpl("http://purl.org/ontology/mo/producesWork");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI productOfComposition = new URIImpl("http://purl.org/ontology/mo/productOfComposition");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI publicationOf = new URIImpl("http://purl.org/ontology/mo/publicationOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: publication of  <br/>
     * Comment: Link a particular manifestation to the related signal, score, libretto, or lyrics  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     * Range: http://purl.org/ontology/mo/MusicalExpression  <br/>
     */
    public static final URI publication_of = new URIImpl("http://purl.org/ontology/mo/publication_of");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: published  <br/>
     * Comment: Used to relate an person or a group of person who published the manifestation of a work.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     */
    public static final URI published = new URIImpl("http://purl.org/ontology/mo/published");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI publishedAs = new URIImpl("http://purl.org/ontology/mo/publishedAs");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: published as  <br/>
     * Comment: Links a musical expression (e.g. a signal or a score) to one of its manifestations (e.g. a track on a particular record or a published score).  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalExpression  <br/>
     * Range: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     */
    public static final URI published_as = new URIImpl("http://purl.org/ontology/mo/published_as");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: publisher  <br/>
     * Comment: Used to relate a musical manifestation to a person or a group of person who published it.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI publisher = new URIImpl("http://purl.org/ontology/mo/publisher");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI publishingLocation = new URIImpl("http://purl.org/ontology/mo/publishingLocation");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: publishingLocation  <br/>
     * Comment: Relates a musical manifestation to its publication location.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     * Range: http://www.w3.org/2003/01/geo/wgs84_pos#SpatialThing  <br/>
     */
    public static final URI publishing_location = new URIImpl("http://purl.org/ontology/mo/publishing_location");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: released record  <br/>
     * Comment: Associates a release with the records it contains. A single release can be associated with multiple records, for example for a multi-disc release.  <br/>
     * Domain: http://purl.org/ontology/mo/Release  <br/>
     * Range: http://purl.org/ontology/mo/Record  <br/>
     */
    public static final URI record = new URIImpl("http://purl.org/ontology/mo/record");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI recordedAs = new URIImpl("http://purl.org/ontology/mo/recordedAs");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: recorded as  <br/>
     * Comment: This is a shortcut property, allowing to bypass all the Sound/Recording steps. This property
		allows to directly link a Performance to the recorded Signal. This is recommended for "normal"
		users. However, advanced users wanting to express things such as the location of the microphone will
		have to create this shortcut as well as the whole workflow, in order to let the "normal" users access
		simply the, well, simple information:-) .  <br/>
     * Domain: http://purl.org/ontology/mo/Performance  <br/>
     * Range: http://purl.org/ontology/mo/Signal  <br/>
     */
    public static final URI recorded_as = new URIImpl("http://purl.org/ontology/mo/recorded_as");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: recorded in  <br/>
     * Comment: Associates a physical Sound to a Recording event where it is being used 
		in order to produce a signal. For example, I might use this property to 
		associate the sound produced by a particular performance of the magic flute
		to a given recording, done using my cell-phone.  <br/>
     * Domain: http://purl.org/ontology/mo/Sound  <br/>
     * Range: http://purl.org/ontology/mo/Recording  <br/>
     */
    public static final URI recorded_in = new URIImpl("http://purl.org/ontology/mo/recorded_in");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: recorded sound  <br/>
     * Comment: Associates a Recording event to a physical Sound being recorded.
                For example, I might use this property to
                associate a given recording, done using my cell phone, to the 
		sound produced by a particular performance of the magic flute.  <br/>
     * Domain: http://purl.org/ontology/mo/Recording  <br/>
     * Range: http://purl.org/ontology/mo/Sound  <br/>
     */
    public static final URI recording_of = new URIImpl("http://purl.org/ontology/mo/recording_of");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: records  <br/>
     * Comment: This is the inverse of the shortcut property recordedAs, allowing to relate directly a performance
		to a signal.  <br/>
     * Domain: http://purl.org/ontology/mo/Signal  <br/>
     * Range: http://purl.org/ontology/mo/Performance  <br/>
     */
    public static final URI records = new URIImpl("http://purl.org/ontology/mo/records");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: release  <br/>
     * Comment: Associates a release with the corresponding release event  <br/>
     * Domain: http://purl.org/ontology/mo/ReleaseEvent  <br/>
     * Range: http://purl.org/ontology/mo/Release  <br/>
     */
    public static final URI release = new URIImpl("http://purl.org/ontology/mo/release");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI releaseStatus = new URIImpl("http://purl.org/ontology/mo/releaseStatus");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI releaseType = new URIImpl("http://purl.org/ontology/mo/releaseType");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Comment: Relates a musical manifestation to its release status (bootleg, ...)  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     * Range: http://purl.org/ontology/mo/ReleaseStatus  <br/>
     */
    public static final URI release_status = new URIImpl("http://purl.org/ontology/mo/release_status");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Comment: Relates a musical manifestation to its release type (interview, spoken word, album, ...)  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     * Range: http://purl.org/ontology/mo/ReleaseType  <br/>
     */
    public static final URI release_type = new URIImpl("http://purl.org/ontology/mo/release_type");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: remaster_of  <br/>
     * Comment: This relates two musical work or the expression of a musical work, where one is a remaster of the other. 
    
A remaster is a new version made for release from source recordings that were earlier released separately. This is usually done to improve the audio quality or adjust for more modern playback equipment. The process generally doesn't involve changing the music in any artistically important way. It may, however, result in tracks that are a few seconds longer or shorter.  <br/>
     */
    public static final URI remaster_of = new URIImpl("http://purl.org/ontology/mo/remaster_of");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: remix_of  <br/>
     * Comment: Used to relate the remix of a musical work in a substantially altered version produced by mixing together individual tracks or segments of an original musical source work.  <br/>
     */
    public static final URI remix_of = new URIImpl("http://purl.org/ontology/mo/remix_of");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: remixed  <br/>
     * Comment: Used to relate an artist who remixed a musical work or the expression of a musical work. 
    
This involves taking just one other musical work and using audio editing to make it sound like a significantly different, but usually still recognisable, song. It can be used to link an artist to a single song that they remixed, or, if they remixed an entire musical work.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicArtist  <br/>
     * Range: http://purl.org/ontology/mo/Signal  <br/>
     */
    public static final URI remixed = new URIImpl("http://purl.org/ontology/mo/remixed");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: remixer  <br/>
     * Comment: Used to relate a musical work or the expression of a musical work to an artist who remixed it. 
    
This involves taking just one other musical work and using audio editing to make it sound like a significantly different, but usually still recognisable, song. It can be used to link an artist to a single song that they remixed, or, if they remixed an entire musical work.  <br/>
     */
    public static final URI remixer = new URIImpl("http://purl.org/ontology/mo/remixer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: review  <br/>
     * Comment: Used to link a work or the expression of a work to a review. 
    
The review does not have to be open content, as long as it is accessible to the general internet population.  <br/>
     * Domain: _:node15g3vghdfx123  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI review = new URIImpl("http://purl.org/ontology/mo/review");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: sampled  <br/>
     * Comment: Used to relate an artist who sampled a Signal.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicArtist  <br/>
     * Range: http://purl.org/ontology/mo/Signal  <br/>
     */
    public static final URI sampled = new URIImpl("http://purl.org/ontology/mo/sampled");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI sampledVersionOf = new URIImpl("http://purl.org/ontology/mo/sampledVersionOf");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: sampled version  <br/>
     * Comment: Associates an analog signal with a sampled version of it  <br/>
     * Domain: http://purl.org/ontology/mo/AnalogSignal  <br/>
     * Range: http://purl.org/ontology/mo/DigitalSignal  <br/>
     */
    public static final URI sampled_version = new URIImpl("http://purl.org/ontology/mo/sampled_version");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: sampled version of  <br/>
     * Comment: Associates a digital signal with the analog version of it  <br/>
     * Domain: http://purl.org/ontology/mo/DigitalSignal  <br/>
     * Range: http://purl.org/ontology/mo/AnalogSignal  <br/>
     */
    public static final URI sampled_version_of = new URIImpl("http://purl.org/ontology/mo/sampled_version_of");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: sampler  <br/>
     * Comment: Used to relate the signal of a musical work to an artist who sampled it.^^http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI sampler = new URIImpl("http://purl.org/ontology/mo/sampler");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: sell_item  <br/>
     * Comment: A person, a group of person or an organization selling an exemplar of a single manifestation.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://purl.org/vocab/frbr/core#Item  <br/>
     */
    public static final URI sell_item = new URIImpl("http://purl.org/ontology/mo/sell_item");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: signal  <br/>
     * Comment: Associates a group of signals with one of the signals it contains  <br/>
     * Domain: http://purl.org/ontology/mo/SignalGroup  <br/>
     * Range: http://purl.org/ontology/mo/Signal  <br/>
     */
    public static final URI signal = new URIImpl("http://purl.org/ontology/mo/signal");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI signalTime = new URIImpl("http://purl.org/ontology/mo/signalTime");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: similar_to  <br/>
     * Comment: A similarity relationships between two objects (so far, either an agent, a signal or a genre, but
		this could grow).
		This relationship is pretty general and doesn't make any assumptions on how the similarity claim
		was derived.
		Such similarity statements can come from a range of different sources (Musicbrainz similarities between
		artists, or coming from some automatic content analysis).
		However, the origin of such statements should be kept using a named graph approach - and ultimately, the 
		documents providing such statements should attach some metadata to themselves (confidence of the claim, etc.).  <br/>
     * Domain: _:node15g3vghdfx127  <br/>
     * Range: _:node15g3vghdfx134  <br/>
     */
    public static final URI similar_to = new URIImpl("http://purl.org/ontology/mo/similar_to");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Comment: Relates a performance to an involved singer  <br/>
     * Domain: http://purl.org/ontology/mo/Performance  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI singer = new URIImpl("http://purl.org/ontology/mo/singer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: supporting_musician  <br/>
     * Comment: Used to relate an artist doing long-time instrumental or vocal support for another artist.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicArtist  <br/>
     * Range: http://purl.org/ontology/mo/MusicArtist  <br/>
     */
    public static final URI supporting_musician = new URIImpl("http://purl.org/ontology/mo/supporting_musician");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#FunctionalProperty <br/>
     * Label: time  <br/>
     * Comment: Associates a Signal to a time object - its actual domain  <br/>
     * Domain: http://purl.org/ontology/mo/Signal  <br/>
     * Range: http://www.w3.org/2006/time#TemporalEntity  <br/>
     */
    public static final URI time = new URIImpl("http://purl.org/ontology/mo/time");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: track  <br/>
     * Comment: Indicates a part of a musical manifestation - in this particular case, a track.  <br/>
     * Domain: http://purl.org/ontology/mo/Record  <br/>
     * Range: http://purl.org/ontology/mo/Track  <br/>
     */
    public static final URI track = new URIImpl("http://purl.org/ontology/mo/track");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: translation_of  <br/>
     * Comment: Indicates that a work or the expression of a work has translated or transliterated into another expression of a work.  <br/>
     * Domain: http://purl.org/vocab/frbr/core#Expression  <br/>
     * Range: http://purl.org/vocab/frbr/core#Expression  <br/>
     */
    public static final URI translation_of = new URIImpl("http://purl.org/ontology/mo/translation_of");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: tribute_to  <br/>
     * Comment: Indicates a musical work or the expression of a musical work that is a tribute to an artist - normally consisting of music being composed by the artist but performed by other artists.  <br/>
     * Domain: http://purl.org/ontology/mo/MusicalManifestation  <br/>
     * Range: http://purl.org/ontology/mo/MusicArtist  <br/>
     */
    public static final URI tribute_to = new URIImpl("http://purl.org/ontology/mo/tribute_to");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI usedInPerformance = new URIImpl("http://purl.org/ontology/mo/usedInPerformance");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI usedInRecording = new URIImpl("http://purl.org/ontology/mo/usedInRecording");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI usesSound = new URIImpl("http://purl.org/ontology/mo/usesSound");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     */
    public static final URI usesWork = new URIImpl("http://purl.org/ontology/mo/usesWork");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: want_item  <br/>
     * Comment: A person, a group of person or an organization wanting an exemplar of a single manifestation.  <br/>
     * Domain: http://xmlns.com/foaf/0.1/Agent  <br/>
     * Range: http://purl.org/vocab/frbr/core#Item  <br/>
     */
    public static final URI want_item = new URIImpl("http://purl.org/ontology/mo/want_item");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: wikipedia  <br/>
     * Comment: Used to link an work, an expression of a work, a manifestation of a work, 
		a person, an instrument or a musical genre to its corresponding WikiPedia page. 
		The full URL should be used, not just the WikiName.  <br/>
     * Domain: _:node15g3vghdfx144  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI wikipedia = new URIImpl("http://purl.org/ontology/mo/wikipedia");
}
