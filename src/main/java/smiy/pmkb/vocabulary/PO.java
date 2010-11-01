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
 * Vocabulary File. Created by org.semanticdesktop.aperture.vocabulary.VocabularyWriter on Mon Nov 01 17:27:29 CET 2010
 * input file: /src/main/resources/smiy/pmkb/vocabulary/po.owl
 * namespace: http://purl.org/ontology/po/
 */
public class PO {

    /** Path to the ontology resource */
    public static final String PO_RESOURCE_PATH = 
      "smiy/pmkb/vocabulary/po.owl";

    /**
     * Puts the PO ontology into the given model.
     * @param model The model for the source ontology to be put into.
     * @throws Exception if something goes wrong.
     */
    public static void getPOOntology(Model model) {
        try {
            InputStream stream = ResourceUtil.getInputStream(PO_RESOURCE_PATH, PO.class);
            if (stream == null) {
                throw new FileNotFoundException("couldn't find resource " + PO_RESOURCE_PATH);
             }
            model.readFrom(stream, Syntax.RdfXml);
        } catch(Exception e) {
             throw new RuntimeException(e);
        }
    }

    /** The namespace for PO */
    public static final URI NS_PO = new URIImpl("http://purl.org/ontology/po/");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: programme  <br/>
     * Comment: A programme, can either be a brand, a series or an episode  <br/>
     */
    public static final URI Programme = new URIImpl("http://purl.org/ontology/po/Programme");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: brand  <br/>
     * Comment: A brand, e.g. `Top Gear'  <br/>
     */
    public static final URI Brand = new URIImpl("http://purl.org/ontology/po/Brand");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: programme item  <br/>
     * Comment: A programme that can have versions, and as such can be broadcast or made available on-demand, e.g. a clip or an episode.  <br/>
     */
    public static final URI ProgrammeItem = new URIImpl("http://purl.org/ontology/po/ProgrammeItem");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: episode  <br/>
     * Comment: A particular episode, e.g. `Top Gear, first episode of the first series' or the film 'A Walk in the Sun' (http://www.bbc.co.uk/programmes/b00gfzdt)  <br/>
     */
    public static final URI Episode = new URIImpl("http://purl.org/ontology/po/Episode");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: clip  <br/>
     * Comment: A particular clip, e.g. `Clip of Top Gear, first series'  <br/>
     */
    public static final URI Clip = new URIImpl("http://purl.org/ontology/po/Clip");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: series  <br/>
     * Comment: A series, e.g. `Top Gear, first season'  <br/>
     */
    public static final URI Series = new URIImpl("http://purl.org/ontology/po/Series");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: category  <br/>
     * Comment: A category provides a way of classifying a set of programmes. Such classifications
        can be performed according to multiple dimensions and taxonomies, e.g. genre, format, places, people, subjects...  <br/>
     */
    public static final URI Category = new URIImpl("http://purl.org/ontology/po/Category");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: genre  <br/>
     * Comment: An anchor point for a programmes' genre taxonomy, e.g. 'Drama'/'Biographical'.  <br/>
     */
    public static final URI Genre = new URIImpl("http://purl.org/ontology/po/Genre");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: format  <br/>
     * Comment: Anchor point for format taxonomies, similar to po:Genre for genre taxonomies.
        Instances of this concept include documentaries, talk shows, animation, etc.  <br/>
     */
    public static final URI Format = new URIImpl("http://purl.org/ontology/po/Format");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: subject  <br/>
     * Comment: Anchor point for subject taxonomies.  <br/>
     */
    public static final URI Subject = new URIImpl("http://purl.org/ontology/po/Subject");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: place  <br/>
     * Comment: A physical place  <br/>
     */
    public static final URI Place = new URIImpl("http://purl.org/ontology/po/Place");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: person  <br/>
     * Comment: A person  <br/>
     */
    public static final URI Person = new URIImpl("http://purl.org/ontology/po/Person");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: version  <br/>
     * Comment: A particular version of an episode.
		Such versions include shortened ones, audio described ones
		or ones that holds sign language.
		The version is associated to a timeline.  <br/>
     */
    public static final URI Version = new URIImpl("http://purl.org/ontology/po/Version");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: original version  <br/>
     * Comment: An `original' version, the legacy version of
		a particular episode.  <br/>
     */
    public static final URI OriginalVersion = new URIImpl("http://purl.org/ontology/po/OriginalVersion");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: audio description  <br/>
     * Comment: A version holding an audio description.  <br/>
     */
    public static final URI AudioDescribedVersion = new URIImpl("http://purl.org/ontology/po/AudioDescribedVersion");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: sign language  <br/>
     * Comment: A version holding sign language.  <br/>
     */
    public static final URI SignedVersion = new URIImpl("http://purl.org/ontology/po/SignedVersion");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: shortened version  <br/>
     * Comment: A shortened version.  <br/>
     */
    public static final URI ShortenedVersion = new URIImpl("http://purl.org/ontology/po/ShortenedVersion");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: broadcast  <br/>
     * Comment: A broadcast event.
		Subsumes the event concept defined in
		the Event ontology.
		A broadcast is associated with a service, and with a
		particular version of an episode.  <br/>
     */
    public static final URI Broadcast = new URIImpl("http://purl.org/ontology/po/Broadcast");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: first broadcast  <br/>
     * Comment: Specifies a broadcast as being the 
		first one of a particular version.  <br/>
     */
    public static final URI FirstBroadcast = new URIImpl("http://purl.org/ontology/po/FirstBroadcast");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: repeat  <br/>
     * Comment: Specifies a broadcast as being a 
		repeat.  <br/>
     */
    public static final URI RepeatBroadcast = new URIImpl("http://purl.org/ontology/po/RepeatBroadcast");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: season  <br/>
     * Comment: A season is a group of broadcasts.  <br/>
     */
    public static final URI Season = new URIImpl("http://purl.org/ontology/po/Season");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: broadcaster  <br/>
     * Comment: An organization responsible of some broadcasting services. 
        It can hold a set of services and outlets.  <br/>
     */
    public static final URI Broadcaster = new URIImpl("http://purl.org/ontology/po/Broadcaster");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: service  <br/>
     * Comment: A broadcasting service.
		Instances of this concept include BBC Radio Wales, BBC Radio 4, BBC News, etc.
        A service is a collection of outlets which contain common material, but with some variations, e.g. by
        region.
        Hence, a service may have multiple outlets (po:Outlet), e.g. BBC Radio 4 has BBC Radio 4 LW and BBC Radio 4 FM.
        A hierarchy of services types is defined within this ontology, e.g. radio and TV.
        A service that is a master brand only (a service that only commissions programmes, e.g. BBC Switch) should 
        be an instance of the top-level po:Service.  <br/>
     */
    public static final URI Service = new URIImpl("http://purl.org/ontology/po/Service");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: outlet  <br/>
     * Comment: Outlet of a particular service, e.g. Radio 4 LW and FM for Radio 4.
        Outlets are services which do not have variations.
        The identity criteria for an outlet is its timeline. 
        For example, Radio 4 LW broadcasts on Analogue Long Wave, but also on Digital Satellite.
        It corresponds to just one outlet, as they are simulcasts.
        The two physical channels for broadcasts correspond to po:Channel.  <br/>
     */
    public static final URI Outlet = new URIImpl("http://purl.org/ontology/po/Outlet");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: physical channel  <br/>
     * Comment: A physical channel on which a broadcast occurs.
        A single outlet or service can be associated with multiple channels. 
        For example, Radio 4 LW broadcasts on Analogue Long Wave and on Digital
        Satellite.  <br/>
     */
    public static final URI Channel = new URIImpl("http://purl.org/ontology/po/Channel");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: radio  <br/>
     * Comment: Services that use a radio medium.  <br/>
     */
    public static final URI Radio = new URIImpl("http://purl.org/ontology/po/Radio");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: radio  <br/>
     * Comment: Radio services aiming at a local coverage.  <br/>
     */
    public static final URI LocalRadio = new URIImpl("http://purl.org/ontology/po/LocalRadio");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: regional radio  <br/>
     * Comment: Radio services aiming at a regional coverage.  <br/>
     */
    public static final URI RegionalRadio = new URIImpl("http://purl.org/ontology/po/RegionalRadio");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: national radio  <br/>
     * Comment: Radio services aiming at a national coverage.  <br/>
     */
    public static final URI NationalRadio = new URIImpl("http://purl.org/ontology/po/NationalRadio");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: tv  <br/>
     * Comment: Services that use a television medium.  <br/>
     */
    public static final URI TV = new URIImpl("http://purl.org/ontology/po/TV");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: web  <br/>
     * Comment: Services that use a Web medium.  <br/>
     */
    public static final URI Web = new URIImpl("http://purl.org/ontology/po/Web");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: FM  <br/>
     * Comment: The FM broadcast band  <br/>
     */
    public static final URI FM = new URIImpl("http://purl.org/ontology/po/FM");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: AM  <br/>
     * Comment: The AM broadcast band  <br/>
     */
    public static final URI LW = new URIImpl("http://purl.org/ontology/po/LW");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: DAB  <br/>
     * Comment: Digital Audio Broadcasting  <br/>
     */
    public static final URI DAB = new URIImpl("http://purl.org/ontology/po/DAB");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: DAB  <br/>
     * Comment: Digital Video Broadcasting  <br/>
     */
    public static final URI DVB = new URIImpl("http://purl.org/ontology/po/DVB");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: IP stream  <br/>
     * Comment: IP stream  <br/>
     */
    public static final URI IPStream = new URIImpl("http://purl.org/ontology/po/IPStream");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: segment  <br/>
     * Comment: Classification of an episode version's region, e.g. 'this track was played at that time'.  <br/>
     */
    public static final URI Segment = new URIImpl("http://purl.org/ontology/po/Segment");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Comment: Classification of an episode version's region corresponding to a musical track being played.  <br/>
     */
    public static final URI MusicSegment = new URIImpl("http://purl.org/ontology/po/MusicSegment");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Comment: Classification of an episode version's region holding speech content.  <br/>
     */
    public static final URI SpeechSegment = new URIImpl("http://purl.org/ontology/po/SpeechSegment");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#Class <br/>
     * Label: subtitle  <br/>
     * Comment: Classification of an episode version's region corresponding to a subtitle being shown.  <br/>
     */
    public static final URI Subtitle = new URIImpl("http://purl.org/ontology/po/Subtitle");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: text  <br/>
     * Comment: Associates a subtitle event to the corresponding text  <br/>
     * Domain: http://purl.org/ontology/po/Subtitle  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI text = new URIImpl("http://purl.org/ontology/po/text");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: frequency  <br/>
     * Comment: Associates a channel to its frequency  <br/>
     * Domain: http://purl.org/ontology/po/Channel  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#float  <br/>
     */
    public static final URI frequency = new URIImpl("http://purl.org/ontology/po/frequency");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: position  <br/>
     * Comment: The position of a particular series or episode within its containing programme. This property can also be used to give the position of an interval within the containing timeline.  <br/>
     * Domain: _:node15g447i9tx11  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#int  <br/>
     */
    public static final URI position = new URIImpl("http://purl.org/ontology/po/position");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: subtitle language  <br/>
     * Comment: Language of the subtitles emebedded in a particular version  <br/>
     * Domain: http://purl.org/ontology/po/Version  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI subtitle_language = new URIImpl("http://purl.org/ontology/po/subtitle_language");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: aspect ratio  <br/>
     * Comment: The aspect ration of a particular version.  <br/>
     * Domain: http://purl.org/ontology/po/Version  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI aspect_ratio = new URIImpl("http://purl.org/ontology/po/aspect_ratio");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: sound format  <br/>
     * Comment: The sound format of a particular version.  <br/>
     * Domain: http://purl.org/ontology/po/Version  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI sound_format = new URIImpl("http://purl.org/ontology/po/sound_format");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: synopsis  <br/>
     * Comment: The synopsis of a serie, brand or episode.  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#string  <br/>
     */
    public static final URI synopsis = new URIImpl("http://purl.org/ontology/po/synopsis");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: short synopsis  <br/>
     * Comment: A short synopsis of a serie, brand or episode.
		Sub-property of po:synopsis.  <br/>
     */
    public static final URI short_synopsis = new URIImpl("http://purl.org/ontology/po/short_synopsis");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: medium synopsis  <br/>
     * Comment: A medium synopsis of a serie, brand or episode.
		Sub-property of po:synopsis.  <br/>
     */
    public static final URI medium_synopsis = new URIImpl("http://purl.org/ontology/po/medium_synopsis");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: long synopsis  <br/>
     * Comment: A long synopsis of a serie, brand or episode.
		Sub-property of po:synopsis.  <br/>
     */
    public static final URI long_synopsis = new URIImpl("http://purl.org/ontology/po/long_synopsis");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: schedule date  <br/>
     * Comment: The schedule date of a broadcast event.  <br/>
     * Domain: http://purl.org/ontology/po/Broadcast  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#date  <br/>
     */
    public static final URI schedule_date = new URIImpl("http://purl.org/ontology/po/schedule_date");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#DatatypeProperty <br/>
     * Label: duration  <br/>
     * Comment: The duration of a version, in seconds.  <br/>
     * Range: http://www.w3.org/2001/XMLSchema#int  <br/>
     */
    public static final URI duration = new URIImpl("http://purl.org/ontology/po/duration");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: masterbrand  <br/>
     * Comment: Associates a programme with its masterbrand (its commissionner)  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://purl.org/ontology/po/Service  <br/>
     */
    public static final URI masterbrand = new URIImpl("http://purl.org/ontology/po/masterbrand");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: track  <br/>
     * Comment: Associates a music segment with a track, as defined in MO  <br/>
     * Domain: http://purl.org/ontology/po/MusicSegment  <br/>
     * Range: http://purl.org/ontology/mo/Track  <br/>
     */
    public static final URI track = new URIImpl("http://purl.org/ontology/po/track");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: broadcast  <br/>
     * Comment: Associates a season to its constituent broadcasts  <br/>
     * Domain: http://purl.org/ontology/po/Season  <br/>
     * Range: http://purl.org/ontology/po/Broadcast  <br/>
     */
    public static final URI season_broadcast = new URIImpl("http://purl.org/ontology/po/season_broadcast");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: outlet  <br/>
     * Comment: Associates a service to an outlet, e.g. Radio 4 to Radio 4 LW.  <br/>
     * Domain: http://purl.org/ontology/po/Service  <br/>
     * Range: http://purl.org/ontology/po/Outlet  <br/>
     */
    public static final URI outlet = new URIImpl("http://purl.org/ontology/po/outlet");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: channel  <br/>
     * Comment: Associates a service to a channel, e.g. Radio 4 LW to Radio 4 LW on Analogue Long Wave.  <br/>
     * Domain: http://purl.org/ontology/po/Service  <br/>
     * Range: http://purl.org/ontology/po/Channel  <br/>
     */
    public static final URI channel = new URIImpl("http://purl.org/ontology/po/channel");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: broadcaster  <br/>
     * Comment: Associates a service to a broadcaster  <br/>
     * Domain: http://purl.org/ontology/po/Service  <br/>
     * Range: http://purl.org/ontology/po/Broadcaster  <br/>
     */
    public static final URI broadcaster = new URIImpl("http://purl.org/ontology/po/broadcaster");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: location  <br/>
     * Comment: Associates a service to a geographic location, 
		aiming at capturing what this service aims at covering.  <br/>
     * Domain: http://purl.org/ontology/po/Service  <br/>
     * Range: http://www.w3.org/2003/01/geo/wgs84_pos#SpatialThing  <br/>
     */
    public static final URI location = new URIImpl("http://purl.org/ontology/po/location");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: episode  <br/>
     * Comment: Associates a brand or a series to an episode constituting it.  <br/>
     * Domain: _:node15g447i9tx1  <br/>
     * Range: http://purl.org/ontology/po/Episode  <br/>
     */
    public static final URI episode = new URIImpl("http://purl.org/ontology/po/episode");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: clip  <br/>
     * Comment: Associates a brand, a series or an episode to a clip.  <br/>
     * Domain: _:node15g447i9tx4  <br/>
     * Range: http://purl.org/ontology/po/Clip  <br/>
     */
    public static final URI clip = new URIImpl("http://purl.org/ontology/po/clip");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#TransitiveProperty <br/>
     * Label: series  <br/>
     * Comment: Associates a brand or a series to a series constituting it.  <br/>
     * Domain: _:node15g447i9tx8  <br/>
     * Range: http://purl.org/ontology/po/Series  <br/>
     */
    public static final URI series = new URIImpl("http://purl.org/ontology/po/series");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#TransitiveProperty <br/>
     * Label: parent serie  <br/>
     * Comment: Relates a series to a series constituting it (eg. `Waking the dead').  <br/>
     * Domain: http://purl.org/ontology/po/Series  <br/>
     * Range: http://purl.org/ontology/po/Series  <br/>
     */
    public static final URI parent_series = new URIImpl("http://purl.org/ontology/po/parent_series");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#TransitiveProperty <br/>
     * Label: parent service  <br/>
     * Comment: Relates a service to another service encapsulating it (eg. `BBC One' and `BBC One South')  <br/>
     * Domain: http://purl.org/ontology/po/Service  <br/>
     * Range: http://purl.org/ontology/po/Service  <br/>
     */
    public static final URI parent_service = new URIImpl("http://purl.org/ontology/po/parent_service");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#FunctionalProperty <br/>
     * Label: service  <br/>
     * Comment: Associate a brand, series or episode to the master brand service.  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://purl.org/ontology/po/Service  <br/>
     */
    public static final URI service = new URIImpl("http://purl.org/ontology/po/service");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#InverseFunctionalProperty <br/>
     * Label: version  <br/>
     * Comment: Associate an episode to a version of it.
		Different versions of a same episode can exist (shortened version, version
		designed for the hearing impaired, etc.).  <br/>
     * Domain: http://purl.org/ontology/po/ProgrammeItem  <br/>
     * Range: http://purl.org/ontology/po/Version  <br/>
     */
    public static final URI version = new URIImpl("http://purl.org/ontology/po/version");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: broadcast on  <br/>
     * Comment: Relates a particular broadcast to the service or outlet on which it was on.
		Sub-property of the event:factor one.  <br/>
     * Domain: http://purl.org/ontology/po/Broadcast  <br/>
     * Range: http://purl.org/ontology/po/Service  <br/>
     */
    public static final URI broadcast_on = new URIImpl("http://purl.org/ontology/po/broadcast_on");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Comment: Deprecated property, left here for historical reasons  <br/>
     */
    public static final URI broadcasted_on = new URIImpl("http://purl.org/ontology/po/broadcasted_on");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: broadcast of  <br/>
     * Comment: Relates a particular broadcast to the version being broadcasted.
		Sub-property of the event:factor one.  <br/>
     * Domain: http://purl.org/ontology/po/Broadcast  <br/>
     * Range: http://purl.org/ontology/po/Version  <br/>
     */
    public static final URI broadcast_of = new URIImpl("http://purl.org/ontology/po/broadcast_of");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: category  <br/>
     * Comment: Relates a programme to a particular category, e.g. genre, format, place...  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://purl.org/ontology/po/Genre  <br/>
     */
    public static final URI category = new URIImpl("http://purl.org/ontology/po/category");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: genre  <br/>
     * Comment: Relates a programme to a particular genre.  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://purl.org/ontology/po/Genre  <br/>
     */
    public static final URI genre = new URIImpl("http://purl.org/ontology/po/genre");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: format  <br/>
     * Comment: Relates a programme to a particular format (eg. `Animation', `Documentary', etc.).  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://purl.org/ontology/po/Format  <br/>
     */
    public static final URI format = new URIImpl("http://purl.org/ontology/po/format");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: subject  <br/>
     * Comment: Relates a programme to a subject (e.g. `easter')  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://purl.org/ontology/po/Subject  <br/>
     */
    public static final URI subject = new URIImpl("http://purl.org/ontology/po/subject");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: place  <br/>
     * Comment: Relates a programme to a place (e.g. `London')  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://purl.org/ontology/po/Place  <br/>
     */
    public static final URI place = new URIImpl("http://purl.org/ontology/po/place");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: person  <br/>
     * Comment: Relates a programme to a person  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://purl.org/ontology/po/Person  <br/>
     */
    public static final URI person = new URIImpl("http://purl.org/ontology/po/person");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: credit  <br/>
     * Comment: Relates a programmes to a person who is credited in it  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI credit = new URIImpl("http://purl.org/ontology/po/credit");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: actor  <br/>
     * Comment: Relates a programmes to one of its actors - a person who plays the role of a character  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI actor = new URIImpl("http://purl.org/ontology/po/actor");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: anchor  <br/>
     * Comment: A television reporter who coordinates a programme  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI anchor = new URIImpl("http://purl.org/ontology/po/anchor");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: participant  <br/>
     * Comment: Relates a programme to one of its participants  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI participant = new URIImpl("http://purl.org/ontology/po/participant");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: commentator  <br/>
     * Comment: Relates a programme to one of its commentators  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI commentator = new URIImpl("http://purl.org/ontology/po/commentator");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: executive producer  <br/>
     * Comment: Relates a programme to its executive producer - a producer who is not involved in any technical aspects of the making process, but who is still responsible for the overall production. Typically an executive producer handles business and legal issues  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI executive_producer = new URIImpl("http://purl.org/ontology/po/executive_producer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: performer  <br/>
     * Comment: Relates a programme to an entertainer who performs a dramatic or musical work for audience  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI performer = new URIImpl("http://purl.org/ontology/po/performer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: director  <br/>
     * Comment: Relates a programme to its supervisor. Generally refers to the person responsible for all audience-visible components of a program, film, or show, whereas the producer is responsible for the financial and other behind-the-scenes aspects. A director's duties might also include casting, script editing, shot selection, shot composition, and editing  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI director = new URIImpl("http://purl.org/ontology/po/director");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: author  <br/>
     * Comment: Relates a programme to its author - the person who created the content  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI author = new URIImpl("http://purl.org/ontology/po/author");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: producer  <br/>
     * Comment: Relates a programme to its producer - the manager of an event, show, or other work, usually the individual in charge of finance, personnel, and other non-artistic aspects in the development of commercials, plays, movies, and other works  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI producer = new URIImpl("http://purl.org/ontology/po/producer");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: news reader  <br/>
     * Comment: Relates a programme to its news reader  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://xmlns.com/foaf/0.1/Agent  <br/>
     */
    public static final URI news_reader = new URIImpl("http://purl.org/ontology/po/news_reader");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: microsite  <br/>
     * Comment: Associates a programme to its microsite. For example http://www.bbc.co.uk/programmes/b00fm04s and http://www.bbc.co.uk/eastenders/  <br/>
     * Domain: http://purl.org/ontology/po/Programme  <br/>
     * Range: http://xmlns.com/foaf/0.1/Document  <br/>
     */
    public static final URI microsite = new URIImpl("http://purl.org/ontology/po/microsite");
    /**
     * Type: Instance of http://www.w3.org/2002/07/owl#ObjectProperty <br/>
     * Label: time  <br/>
     * Comment: Associates an episode's version or a version's segment with a temporal interval. This interval can be associated with a timeline, serving as an anchor for further temporal annotations, e.g. subtitles or played track  <br/>
     * Domain: _:node15g447i9tx15  <br/>
     * Range: http://purl.org/NET/c4dm/timeline.owl#Interval  <br/>
     */
    public static final URI time = new URIImpl("http://purl.org/ontology/po/time");
}
