/**
 * Copyright (c) 2010 SMI.
 * All rights reserved.
 * 
 * Licensed under the Aperture BSD-style license.
 * 
 * @author Bob Ferris
 */
package smiy.pmkb.extractor.audiodocuments.mp3;

import java.util.HashMap;

import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.model.node.impl.URIImpl;

import smiy.pmkb.util.Namespaces;

/**
 * The genre list as defined in http://www.id3.org/id3v2.3.0.
 */
public enum GenreUri
{

	Blues(0, GenreUri.BLUES), ClassicRock(1, GenreUri.CLASSICROCK), Country(2,
			GenreUri.COUNTRY), Dance(3, GenreUri.DANCE), Disco(4,
			GenreUri.DISCO), Funk(5, GenreUri.FUNK), Grunge(6, GenreUri.GRUNGE), HipHop(
			7, GenreUri.HIPHOP), Jazz(8, GenreUri.JAZZ), Metal(9,
			GenreUri.METAL), NewAge(10, GenreUri.NEWAGE), Oldies(11,
			GenreUri.OLDIES), Other(12, GenreUri.OTHER), Pop(13, GenreUri.POP), RnB(
			14, GenreUri.RNB), Rap(15, GenreUri.RAP), Reggae(16,
			GenreUri.REGGAE), Rock(17, GenreUri.ROCK), Techno(18,
			GenreUri.TECHNO), Industrial(19, GenreUri.INDUSTRIAL), Alternative(
			20, GenreUri.ALTERNATIVE), Ska(21, GenreUri.SKA), DeathMetal(22,
			GenreUri.DEATHMETAL), Pranks(23, GenreUri.PRANKS), Soundtrack(24,
			GenreUri.SOUNDTRACK), EuroTechno(25, GenreUri.EUROTECHNO), Ambient(
			26, GenreUri.AMBIENT), TripHop(27, GenreUri.TRIPHOP), Vocal(28,
			GenreUri.VOCAL), JazzFunk(29, GenreUri.JAZZFUNK), Fusion(30,
			GenreUri.FUSION), Trance(31, GenreUri.TRANCE), Classical(32,
			GenreUri.CLASSICAL), Instrumental(33, GenreUri.INSTRUMENTAL), Acid(
			34, GenreUri.ACID), House(35, GenreUri.HOUSE), Game(36,
			GenreUri.GAME), SoundClip(37, GenreUri.SOUNDCLIP), Gospel(38,
			GenreUri.GOSPEL), Noise(39, GenreUri.NOISE), AlternRock(40,
			GenreUri.ALTERNATIVEROCK), Bass(41, GenreUri.BASS), Soul(42,
			GenreUri.SOUL), Punk(43, GenreUri.PUNK), Space(44, GenreUri.SPACE), Meditative(
			45, GenreUri.MEDITATIVE), InstrumentalPop(46,
			GenreUri.INSTRUMENTALPOP), InstrumentalRock(47,
			GenreUri.INSTRUMENTALROCK), Ethnic(48, GenreUri.ETHNIC), Gothic(49,
			GenreUri.GOTHIC), Darkwave(50, GenreUri.DARKWAVE), TechnoIndustrial(
			51, GenreUri.TECHNOINDUSTRIAL), Electronic(52, GenreUri.ELECTRONIC), PopFolk(
			53, GenreUri.POPFOLK), Eurodance(54, GenreUri.EURODANCE), Dream(55,
			GenreUri.DREAM), SouthernRock(56, GenreUri.SOUTHERNROCK), Comedy(
			57, GenreUri.COMEDY), Cult(58, GenreUri.CULT), Gangsta(59,
			GenreUri.GANGSTA), Top40(60, GenreUri.TOP40), ChristianRap(61,
			GenreUri.CHRISTIANRAP), PopFunk(62, GenreUri.POPFUNK), Jungle(63,
			GenreUri.JUNGLE), NativeAmerican(64, GenreUri.NATIVEAMERICAN), Cabaret(
			65, GenreUri.CABARET), NewWave(66, GenreUri.NEWWAVE), Psychadelic(
			67, GenreUri.PSYCHADELIC), Rave(68, GenreUri.RAVE), Showtunes(69,
			GenreUri.SHOWTUNES), Trailer(70, GenreUri.TRAILER), LoFi(71,
			GenreUri.LOFI), Tribal(72, GenreUri.TRIBAL), AcidPunk(73,
			GenreUri.ACIDPUNK), AcidJazz(74, GenreUri.ACIDJAZZ), Polka(75,
			GenreUri.POLKA), Retro(76, GenreUri.RETRO), Musical(77,
			GenreUri.MUSICAL), RockAndRoll(78, GenreUri.ROCKNROLL), HardRock(
			79, GenreUri.HARDROCK),

	// the winamp extensions
	Folk(80, GenreUri.FOLK), FolkRock(81, GenreUri.FOLKROCK), NationalFolk(82,
			GenreUri.NATIONALFOLK), Swing(83, GenreUri.SWING), FastFusion(84,
			GenreUri.FASTFUSION), Bebop(85, GenreUri.BEBOP), Latin(86,
			GenreUri.LATIN), Revival(87, GenreUri.REVIVAL), Celtic(88,
			GenreUri.CELTIC), Bluegrass(89, GenreUri.BLUEGRASS), Avantgarde(90,
			GenreUri.AVANTGARDE), GothicRock(91, GenreUri.GOTHICROCK), ProgressiveRock(
			92, GenreUri.PROGRESSIVEROCK), PsychedelicRock(93,
			GenreUri.PSYCHEDELICROCK), SymphonicRock(94, GenreUri.SYMPHONICROCK), SlowRock(
			95, GenreUri.SLOWROCK), BigBand(96, GenreUri.BIGBAND), Chorus(97,
			GenreUri.CHORUS), EasyListening(98, GenreUri.EASYLISTENING), Acoustic(
			99, GenreUri.ACOUSTIC), Humour(100, GenreUri.HUMOUR), Speech(101,
			GenreUri.SPEECH), Chanson(102, GenreUri.CHANSON), Opera(103,
			GenreUri.OPERA), ChamberMusic(104, GenreUri.CHAMBERMUSIC), Sonata(
			105, GenreUri.SONATA), Symphony(106, GenreUri.SYMPHONY), BootyBass(
			107, GenreUri.BOOTYBASS), Primus(108, GenreUri.PRIMUS), PornGroove(
			109, GenreUri.PORNGROOVE), Satire(110, GenreUri.SATIRE), SlowJam(
			111, GenreUri.SLOWJAM), Club(112, GenreUri.CLUB), Tango(113,
			GenreUri.TANGO), Samba(114, GenreUri.SAMBA), Folklore(115,
			GenreUri.FOLKLORE), Ballad(116, GenreUri.BALLAD), PowerBallad(117,
			GenreUri.POWERBALLAD), RhytmicSoul(118, GenreUri.RHYTHMICSOUL), Freestyle(
			119, GenreUri.FREESTYLE), Duet(120, GenreUri.DUET), PunkRock(121,
			GenreUri.PUNKROCK), DrumSolo(122, GenreUri.DRUMSOLO), ACapella(123,
			GenreUri.ACAPELLA), EuroHouse(124, GenreUri.EUROHOUSE), DanceHall(
			125, GenreUri.DANCEHALL);

	private int id;
	private URI uri;

	public static final String GENRE_RURI = "/genre/";

	private static final URI BLUES = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Blues");
	private static final URI CLASSICROCK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "ClassicRock");
	private static final URI COUNTRY = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Country");
	private static final URI DANCE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Dance");
	private static final URI DISCO = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Disco");
	private static final URI FUNK = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "Funk");
	private static final URI GRUNGE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Grunge");
	private static final URI HIPHOP = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "HipHop");
	private static final URI JAZZ = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "Jazz");
	private static final URI METAL = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Metal");
	private static final URI NEWAGE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "NewAge");
	private static final URI OLDIES = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Oldies");
	private static final URI OTHER = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Other");
	private static final URI POP = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "Pop");
	private static final URI RNB = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "RnB");
	private static final URI RAP = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "Rap");
	private static final URI REGGAE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Reggae");
	private static final URI ROCK = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "Rock");
	private static final URI TECHNO = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Techno");
	private static final URI INDUSTRIAL = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Industrial");
	private static final URI ALTERNATIVE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Alternative");
	private static final URI SKA = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "Ska");
	private static final URI DEATHMETAL = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "DeathMetal");
	private static final URI PRANKS = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Pranks");
	private static final URI SOUNDTRACK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Soundtrack");
	private static final URI EUROTECHNO = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "EuroTechno");
	private static final URI AMBIENT = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Ambient");
	private static final URI TRIPHOP = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "TripHop");
	private static final URI VOCAL = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Vocal");
	private static final URI JAZZFUNK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "JazzFunk");
	private static final URI FUSION = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Fusion");
	private static final URI TRANCE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Trance");
	private static final URI CLASSICAL = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Classical");
	private static final URI INSTRUMENTAL = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Instrumental");
	private static final URI ACID = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "Acid");
	private static final URI HOUSE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "House");
	private static final URI GAME = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "Game");
	private static final URI SOUNDCLIP = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "SoundClip");
	private static final URI GOSPEL = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Gospel");
	private static final URI NOISE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Noise");
	private static final URI ALTERNATIVEROCK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "AlternativeRock");
	private static final URI BASS = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "Bass");
	private static final URI SOUL = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "Soul");
	private static final URI PUNK = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "Punk");
	private static final URI SPACE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Space");
	private static final URI MEDITATIVE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Meditative");
	private static final URI INSTRUMENTALPOP = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "InstrumentalPop");
	private static final URI INSTRUMENTALROCK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "InstrumentalRock");
	private static final URI ETHNIC = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Ethnic");
	private static final URI GOTHIC = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Gothic");
	private static final URI DARKWAVE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Darkwave");
	private static final URI TECHNOINDUSTRIAL = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "TechnoIndustrial");
	private static final URI ELECTRONIC = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Electronic");
	private static final URI POPFOLK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "PopFolk");
	private static final URI EURODANCE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Eurodance");
	private static final URI DREAM = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Dream");
	private static final URI SOUTHERNROCK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "SouthernRock");
	private static final URI COMEDY = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Comedy");
	private static final URI CULT = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "Cult");
	private static final URI GANGSTA = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "GANGSTA");
	private static final URI TOP40 = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "TOP40");
	private static final URI CHRISTIANRAP = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "ChristianRap");
	private static final URI POPFUNK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "PopFunk");
	private static final URI JUNGLE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Jungle");
	private static final URI NATIVEAMERICAN = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "NativeAmerican");
	private static final URI CABARET = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Cabaret");
	private static final URI NEWWAVE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "NewWave");
	private static final URI PSYCHADELIC = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Psychadelic");
	private static final URI RAVE = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "Rave");
	private static final URI SHOWTUNES = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Showtunes");
	private static final URI TRAILER = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Trailer");
	private static final URI LOFI = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "LoFi");
	private static final URI TRIBAL = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Tribal");
	private static final URI ACIDPUNK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "AcidPunk");
	private static final URI ACIDJAZZ = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "AcidJazz");
	private static final URI POLKA = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Polka");
	private static final URI RETRO = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Retro");
	private static final URI MUSICAL = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Musical");
	private static final URI ROCKNROLL = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "RocknRoll");
	private static final URI HARDROCK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "HardRock");

	// the winamp extensions
	private static final URI FOLK = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "Folk");
	private static final URI FOLKROCK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "FolkRock");
	private static final URI NATIONALFOLK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "NationalFolk");
	private static final URI SWING = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Swing");
	private static final URI FASTFUSION = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "FastFusion");
	private static final URI BEBOP = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Bebop");
	private static final URI LATIN = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Latin");
	private static final URI REVIVAL = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Revival");
	private static final URI CELTIC = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Celtic");
	private static final URI BLUEGRASS = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Bluegrass");
	private static final URI AVANTGARDE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Avantgarde");
	private static final URI GOTHICROCK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "GothicRock");
	private static final URI PROGRESSIVEROCK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "ProgressiveRock");
	private static final URI PSYCHEDELICROCK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "PsychedelicRock");
	private static final URI SYMPHONICROCK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "SymphonicRock");
	private static final URI SLOWROCK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "SlowRock");
	private static final URI BIGBAND = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "BigBand");
	private static final URI CHORUS = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Chorus");
	private static final URI EASYLISTENING = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "EasyListening");
	private static final URI ACOUSTIC = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Acoustic");
	private static final URI HUMOUR = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Humour");
	private static final URI SPEECH = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Speech");
	private static final URI CHANSON = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Chanson");
	private static final URI OPERA = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Opera");
	private static final URI CHAMBERMUSIC = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "ChamberMusic");
	private static final URI SONATA = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Sonata");
	private static final URI SYMPHONY = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Symphony");
	private static final URI BOOTYBASS = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "BootyBass");
	private static final URI PRIMUS = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Primus");
	private static final URI PORNGROOVE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "PornGroove");
	private static final URI SATIRE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Satire");
	private static final URI SLOWJAM = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "SlowJam");
	private static final URI CLUB = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "Club");
	private static final URI TANGO = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Tango");
	private static final URI SAMBA = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Samba");
	private static final URI FOLKLORE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Folklore");
	private static final URI BALLAD = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Ballad");
	private static final URI POWERBALLAD = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "PowerBallad");
	private static final URI RHYTHMICSOUL = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "RhythmicSoul");
	private static final URI FREESTYLE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "Freestyle");
	private static final URI DUET = new URIImpl(Namespaces.PMKB_NS + GENRE_RURI
			+ "Duet");
	private static final URI PUNKROCK = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "PunkRock");
	private static final URI DRUMSOLO = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "DrumSolo");
	private static final URI ACAPELLA = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "ACapella");
	private static final URI EUROHOUSE = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "EuroHouse");
	private static final URI DANCEHALL = new URIImpl(Namespaces.PMKB_NS
			+ GENRE_RURI + "DanceHall");

	GenreUri(int id, URI uri)
	{
		this.id = id;
		this.uri = uri;
	}

	public URI getUri()
	{
		return uri;
	}

	public int getId()
	{
		return id;
	}

	private static HashMap<URI, GenreUri> urisToNumbersMap;

	static
	{
		urisToNumbersMap = new HashMap<URI, GenreUri>(2 * values().length);
		for (GenreUri genre : values())
		{
			urisToNumbersMap.put(genre.getUri(), genre);
		}
	}

	public static GenreUri getGenreByUri(URI uri)
	{
		return urisToNumbersMap.get(uri);
	}

	public static GenreUri getGenreByByteId(byte id)
	{
		int convertedByte = (id >= 0 ? id : (int) id + 256);
		if (convertedByte < 0 || convertedByte >= values().length)
		{
			return null;
		}
		else
		{
			return values()[convertedByte];
		}
	}

	public static GenreUri getGenreByIntId(int id)
	{
		if (id < 0 || id >= values().length)
		{
			return null;
		}
		else
		{
			return values()[id];
		}
	}
}
