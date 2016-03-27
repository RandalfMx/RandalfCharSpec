/**
 * 
 */
package mx.randalf.charSpec;

import java.util.Hashtable;

import org.apache.log4j.Logger;


/**
 * Questa classe viene utilizzata per la inizializzazione delle variabili
 * d'ambiente dei caratteri speciali
 * 
 * @author Massimiliano Randazzo
 * 
 */
class InitSpeChar
{

	private Logger log = Logger.getLogger(InitSpeChar.class);

	/**
	 * Questa variabile viene utilizzata per indicare la lista dei caratteri
	 * speciali per la conversione
	 */
	private String[][] initSpeChar = null;
	
	private Hashtable<String, String> htInitSpeChar = null;

	private int tipo = -1;
	
	/**
	 * Costruttore
	 * 
	 * @param tipo
	 *          Questa variabile vinee utilizzata la tipologia della conversione<br/>
	 *          1. Sbn -> Unicode Html<br/> 
	 *          2. Sbn -> Unicode Text<br/> 
	 *          3. Sbn -> Iso8859 Html<br/> 
	 *          4. Sbn -> Iso8859 Text<br/> 
	 *          5. Sbn -> Normalizzazione<br/> 
	 *          6. Unicode Html -> Sbn<br/> 
	 *          7. Unicode Text -> Sbn<br/> 
	 *          8. Iso8859 Html -> Sbn<br/> 
	 *          9. Iso8859 Text -> Sbn<br/>
	 *          10. Unicode Text -> Normalizzazione<br/> 
	 *          11. Iso8859 Text -> Normalizzazione<br/> 
	 */
	public InitSpeChar(int tipo)
	{
		String[][] initSpeChar;
		int y = -1;

		initSpeChar = init();
		htInitSpeChar = new Hashtable<String, String>();
		this.tipo=tipo;

		this.initSpeChar = new String[initSpeChar.length - 1][2];

		for (int x = 1; x < initSpeChar.length; x++)
		{
			if (tipo == 1)
			{
				y++;
				this.initSpeChar[y][0] = initSpeChar[x][0];
				this.initSpeChar[y][1] = initSpeChar[x][1];
			}
			else if (tipo == 2)
			{
				y++;
				this.initSpeChar[y][0] = initSpeChar[x][0];
				this.initSpeChar[y][1] = initSpeChar[x][2];
			}
			else if (tipo == 3)
			{
				y++;
				this.initSpeChar[y][0] = initSpeChar[x][0];
				this.initSpeChar[y][1] = initSpeChar[x][3];
			}
			else if (tipo == 4)
			{
				y++;
				this.initSpeChar[y][0] = initSpeChar[x][0];
				this.initSpeChar[y][1] = initSpeChar[x][4];
			}
			else if (tipo == 5)
			{
				y++;
				this.initSpeChar[y][0] = initSpeChar[x][0];
				this.initSpeChar[y][1] = initSpeChar[x][5];
			}
			else if (tipo == 6)
			{
				y++;
				this.initSpeChar[y][0] = initSpeChar[x][1];
				this.initSpeChar[y][1] = initSpeChar[x][0];
			}
			else if (tipo == 7)
			{
				y++;
				this.initSpeChar[y][0] = initSpeChar[x][2];
				this.initSpeChar[y][1] = initSpeChar[x][0];
				htInitSpeChar.put(initSpeChar[x][2], initSpeChar[x][0]);
			}
			else if (tipo == 8)
			{
				if (initSpeChar[x][3].startsWith("&"))
				{
					y++;
					this.initSpeChar[y][0] = initSpeChar[x][3];
					this.initSpeChar[y][1] = initSpeChar[x][0];
				}
			}
			else if (tipo == 9)
			{
				if (initSpeChar[x][3].startsWith("&"))
				{
					y++;
					this.initSpeChar[y][0] = initSpeChar[x][4];
					this.initSpeChar[y][1] = initSpeChar[x][0];
					htInitSpeChar.put(initSpeChar[x][4], initSpeChar[x][0]);
				}
			}
			else if (tipo == 10)
			{
				y++;
				this.initSpeChar[y][0] = initSpeChar[x][2];
				this.initSpeChar[y][1] = initSpeChar[x][5];
			}
			else if (tipo == 11)
			{
				if (initSpeChar[x][3].startsWith("&"))
				{
  				y++;
  				this.initSpeChar[y][0] = initSpeChar[x][4];
  				this.initSpeChar[y][1] = initSpeChar[x][5];
				}
			}
		}
	}

	/**
	 * Questo metodo viene utilizzato per l'inizializzazione dei caratteri
	 * speciali
	 * 
	 * @return Lista caratteri Speciali
	 */
	private String[][] init()
	{
		String[][] initSpeChar = {
				{ "Codice Sbn",  "Codice Unicode Html", "Codifica Unicode","Codice Iso 8859 html", "Codice Iso 8859", "Codice Normalizzato","Descrizione" },
				{ "\u001BW0 10",  "&#145;",             "\u00CA\u00BB",    "$#145;", 							 "\u00CA\u00BB", 			"", 																		"AIN" },
				{ "\u001BW0 10",  "&#145;",             "\u0091",          "$#145;", 							 "\u0091", 									"", 																		"AIN" },
				{ "\u001BW0 10",  "&#703;",             "\u02BF",          "$#703;", 							 "\u02BF", 									"", 																		"AIN" },
				{ "\u001BW0 11",  "&#702;",             "\u00CA\u00BC",    "&#700;",               "\u00CA\u00BC",    "",                   "ALIF" },
				{ "\u001BW0 11",  "&#702;",             "\uCABC",          "&#700;",               "\uCABC",          "",                   "ALIF" },
				{ "\u001BW0 11",  "&#702;",             "\u02BE",          "&#700;",               "\u02BE",          "", 																		"ALIF" },
				{ "\u001BW0 11",  "&#702;",             "\u02BC",          "&#700;",               "\u02BC",          "", 																		"ALIF" },
				{ "\u001BW0 1-",  "&#169;",             "\u00A9",          "&#169;",               "\u00A9",          "C", 																	"COPYRIGHT" },
				{ "\u001BW0 1,",  "&#9837;",            "\u266D",          "b",                    "b",               "B", 																	"BEMOLLE" },
				{ "\u001BW0 1;",  "&#187;",             "\u00BB",          "&#187;",               "\u00BB",          "",  																	"VIRGOLETTE AD ANGOLO (CHIUSE)" },
				{ "\u001BW0 1!",  "&#161;",             "\u00A1",          "&#161;",               "\u00A1",          "",  																	"PUNTO ESCLAMATIVO ROVESCIATO" },
				{ "\u001BW0 1?",  "&#191;",             "\u00BF",          "&#191;",               "\u00BF",          "",  																	"PUNTO INTERROGATIVO ROVESCIATO" },
				{ "\u001BW0 1.",  "&#8471;",            "\u2117",          "p",                    "p",               "P", 																	"PHONOGRAPHE" },
				{ "\u001BW0 1'",  "&#167;",             "\u00A7",          "&#167;",               "\u00A7",          "",																			"PARAGRAFO" },
				{ "\u001BW0 1\"", "&#132;",             "\u0084",          "&#132;",               "\u0084",          "",																			"VIRGOLETTE SOTTO LINEA (APERTE)" },
				{ "\u001BW0 1(",  "&#8242;",            "\u2032",          "", 										"", 															"*", 																	"PRIMO SOPRASCRITTO" },
				{ "\u001BW0 1)",  "&#8216;",            "\u2018",          "`", 																			"`", 														"",																			"VIRGOLETTA SOPRA LINEA (APERTA)" },
				{ "\u001BW0 1{",  "&#223;",             "\u00DF",          "&#223;", 														"\u00DF", 									"SS",																	"SZ TEDESCO" },
				{ "\u001BW0 1/",  "&#174;",             "\u00AE",          "&#174;", 														"\u00AE", 									"R",																		"MARCHIO REGISTRATO" },
				{ "\u001BW0 1&",  "&#8224;",            "\u2020",          "+", 																			"+", 														"*", 																	"CROCE SEMPLICE" },
				{ "\u001BW0 1#",  "&#163;",             "\u00A3",          "&#163;", 														"\u00A3", 									"*",																		"STERLINA" },
				{ "\u001BW0 1%",  "&#165;",             "\u00A5",          "&#165;", 														"\u00A5", 									"*", 																	"YEN" },
				{ "\u001BW0 1+",  "&#171;",             "\u00AB",          "&#171;", 														"\u00AB", 									"",																			"VIRGOLETTE AD ANGOLO (APERTE)" },
				{ "\u001BW0 1=",  "&#697;",             "\u02B9",          "`", 																			"`", 														"",																			"SEGNO DI DEBOLE (RUSSO TRASL.)" },
				{ "\u001BW0 1>",  "&#698;",             "\u02BA",          "&#132;", 														"\u0084", 									"",																			"SEGNO DI FORTE (RUSSO TRASL.)" },
//				{ "\u001BW0 1$",  "&#36;",              "\u0024",          "$", 																			"$", 														"*", 																	"DOLLARO" },
				{ "\u001BW0 12", 	"&#8218;", 						"\u201A", "`", "`", "",						"VIRGOLETTA SOTTO LINEA (APERTA)" },
				{ "\u001BW0 16", 	"&#8225;", "\u2021", "+", "+", "*", "CROCE DOPPIA" },
				{ "\u001BW0 17", 	"&#8228;", "\u2024", ".", ".", "",						"PUNTO IN MEZZO CATALANO" },
				{ "\u001BW0 18", 	"&#8243;", "\u2033", "&#34;", "\"", "*",						"Secondo SOPRASCRITTO" },
				{ "\u001BW0 19", 	"&#146;", "\u0092", "&#146;", "\u0092", "",						"VIRGOLETTA SOPRA LINEA (CHIUSA)" },
				{ "\u001BW0 1a", 	"&#198;", "\u00C6", "&#198;", "\u00C6", "AE",						"NESSO AE MAIUSCOLO" },
				{ "\u001BW0 1b", 	"&#208;", "\u00D0", "&#208;", "\u00D0", "D",						"D TAGLIATA MAIUSCOLA" },
				{ "\u001BW0 1f", 	"&#306;", "\u0132", "IJ", "IJ", "IJ",						"IJ OLANDESE MAIUSCOLA" },
				{ "\u001BW0 1h", 	"&#321;", "\u0141", "L", "L", "L",						"L TAGLIATA MAIUSCOLA" },
				{ "\u001BW0 1i", 	"&#216;", "\u00D8", "&#216;", "\u00D8", "O",						"O TAGLIATA MAIUSCOLA" },
				{ "\u001BW0 1j", 	"&#338;", "\u0152", "OE", "OE", "OE",						"NESSO OE MAIUSCOLO" },
				{ "\u001BW0 1l", 	"&#421;", "\u01A5", "th", "th", "TH",						"THORNMINUSCOLO (ISLANDESE)" },
				{ "\u001BW0 1L", 	"&#420;", "\u01A4", "TH", "TH", "TH",						"THORN MAIUSCOLO (ISLANDESE)" },
				{ "\u001BW0 1q", 	"&#230;", "\u00E6", "&#230;", "\u00E6", "AE",						"NESSO AE MINUSCOLO" },
				{ "\u001BW0 1r", 	"&#273;", "\u0111", "d", "d", "D",						"D TAGLIATA MINUSCOLA" },
				{ "\u001BW0 1s", 	"&#240;", "\u00F0", "&#240;", "\u00F0", "D",						"ETH ISLANDESE" },
				{ "\u001BW0 1u", 	"&#305;", "\u0131", "i", "i", "I", "I MINUSCOLA TURCA" },
				{ "\u001BW0 1v", 	"&#307;", "\u0133", "ij", "ij", "IJ",						"IJ OLANDESE MINUSCOLA" },
				{ "\u001BW0 1x", 	"&#322;", "\u0142", "l", "l", "L",						"L TAGLIATA MINUSCOLA" },
				{ "\u001BW0 1y", 	"&#248;", "\u00F8", "&#248;", "\u00F8", "O",						"O TAGLIATA MINUSCOLA" },
				{ "\u001BW0 1z", 	"&#339;", "\u0153", "oe", "oe", "OE",						"NESSO OE MINUSCOLO" },
				{ "\u001BW0 2`", 	"&#937;", "\u03A9", "OHM", "OHM", "OHM", "OHM" },
				{ "\u001BW0 2\"",	"&#162;", "\u00A2", "&#162;", "\u00A2", "*", "CENT" },
				{ "\u001BW0 2}", 	"&#359;", "\u0167", "t", "t", "T",						"T TAGLIATA MINUSCOLA" },
				{ "\u001BW0 2~", 	"&#331;", "\u014B", "n", "n", "N",						"ENG MINUSCOLO (LINGUE INDIANI DI AMERICA)" },
				{ "\u001BW0 20", 	"&#176;", "\u00B0", "&#176;", "\u00B0", "*", "GRADO" },
				{ "\u001BW0 21", 	"&#177;", "\u00B1", "&#177;", "\u00B1", "*",						"PIU MENO" },
				{ "\u001BW0 22", 	"&#178;", "\u00B2", "&#178;", "\u00B2", "2",						"ESPONENTE 2" },
				{ "\u001BW0 23", 	"&#179;", "\u00B3", "&#179;", "\u00B3", "3",						"ESPONENTE 3" },
				{ "\u001BW0 24", 	"&#215;", "\u00D7", "&#215;", "\u00D7", "X", "MOLTIPLICATO" },
				{ "\u001BW0 25", 	"&#181;", "\u00B5", "&#181;", "\u00B5", "MM", "MICRON" },
				{ "\u001BW0 26", 	"&#182;", "\u00B6", "&#182;", "\u00B6", "", "SEZIONE" },
				{ "\u001BW0 27", 	"&#8228;", "\u2024", "x", "x", "X",						"PUNTO IN MEZZO MATEMATICO" },
				{ "\u001BW0 28", 	"&#247;", "\u00F7", "&#247;", "\u00F7", "*", "DA A" },
				{ "\u001BW0 2c", 	"&#170;", "\u00AA", "&#170;", "\u00AA", "A",						"INDICATORE DI ORDINALE (FEMMINILE)" },
				{ "\u001BW0 2d", 	"&#294;", "\u0126", "H", "H", "H",						"H TAGLIATA MAIUSCOLA" },
				{ "\u001BW0 2g", 	"&#319;", "\u013F", "L", "L", "L",						"L CON PUNTO MAIUSCOLA" },
				{ "\u001BW0 2k", 	"&#186;", "\u00BA", "&#186;", "\u00BA", "O",						"INDICATORE DI ORDINALE (MASCHILE)" },
				{ "\u001BW0 2m", 	"&#358;", "\u0166", "T", "T", "T",						"T TAGLIATA MAIUSCOLA" },
				{ "\u001BW0 2n", 	"&#330;", "\u014A", "N", "N", "N",						"ENG MAIUSCOLO (LINGUE INDIANI DI AMERICA)" },
				{ "\u001BW0 2o", 	"&#329;", "\u0149", "n", "n", "N",						"N CON APOSTROFO MINUSCOLA" },
				{ "\u001BW0 2p", 	"&#312;", "\u0138", "k", "k", "K", "K RIDOTTA" },
				{ "\u001BW0 2Q", 	"&#185;", "\u00B9", "&#185;", "\u00B9", "1",						"ESPONENTE 1" },
				{ "\u001BW0 2t", "&#295;", "\u0127", "h", "h", "H",						"H TAGLIATA MINUSCOLA" },
				{ "\u001BW0 2T", "&#8482;", "\u2122", "TM", "TM", "TM", "TRADE MARK" },
				{ "\u001BW0 2U", "&#9834;", "\u266A", "*", "*", "*", "NOTA DI MUSICA" },
				{ "\u001BW0 2w", "&#320;", "\u0140", "l", "l", "L",						"L CON PUNTO MINUSCOLA" },
				{ "\u001BW0 3^", "&#992;", "\u03E0", "900", "900", "900", "SAMPI MAIU" },
				{ "\u001BW0 3[", "&#935;", "\u03A7", "Ch", "Ch", "CH", "CHI MAIU" },
				{ "\u001BW0 3]", "&#937;", "\u03A9", "O", "O", "O", "OMEGA MAIU" },
				{ "\u001BW0 3{", "&#967;", "\u03C7", "ch", "ch", "CH", "CHI MIN" },
				{ "\u001BW0 3}", "&#969;", "\u03C9", "o", "o", "O", "OMEGA MIN" },
				{ "\u001BW0 3\"", "&#936;", "\u03A8", "Ps", "Ps", "PS", "PSI MAIU" },
				{ "\u001BW0 3|", "&#968;", "\u03C8", "ps", "ps", "ps", "PSI MIN" },
				{ "\u001BW0 3~", "&#993;", "\u03E1", "900", "900", "900", "SAMPI MIN" },
				{ "\u001BW0 3A", "&#913;", "\u0391", "A", "A", "A", "ALFA MAIU" },
				{ "\u001BW0 3a", "&#945;", "\u03B1", "a", "a", "A", "ALFA MIN" },
				{ "\u001BW0 3B", "&#914;", "\u0392", "B", "B", "B", "BETA MAIU" },
				{ "\u001BW0 3b", "&#946;", "\u03B2", "b", "b", "B", "BETA MIN" },
				{ "\u001BW0 3D", "&#915;", "\u0393", "G", "G", "G", "GAMMA MAIU" },
				{ "\u001BW0 3d", "&#947;", "\u03B3", "g", "g", "G", "GAMMA MIN" },
				{ "\u001BW0 3E", "&#916;", "\u0394", "D", "D", "D", "DELTA MAIU" },
				{ "\u001BW0 3e", "&#948;", "\u03B4", "d", "d", "D", "DELTA MIN" },
				{ "\u001BW0 3F", "&#917;", "\u0395", "E", "E", "E", "EPSILON MAIU" },
				{ "\u001BW0 3f", "&#949;", "\u03B5", "e", "e", "E", "EPSILON MIN" },
				{ "\u001BW0 3G", "&#986;", "\u03DA", "6", "6", "6", "STIGMA MAIU" },
				{ "\u001BW0 3g", "&#987;", "\u03DB", "6", "6", "6", "STIGMA MIN" },
				{ "\u001BW0 3H", "&#988;", "\u03DC", "6", "6", "6", "DIGAMMA MAIU" },
				{ "\u001BW0 3h", "&#989;", "\u03DD", "6", "6", "6", "DIGAMMA MIN" },
				{ "\u001BW0 3I", "&#918;", "\u0396", "Z", "Z", "Z", "ZETA MAIU" },
				{ "\u001BW0 3i", "&#950;", "\u03B6", "z", "z", "Z", "ZETA MIN" },
				{ "\u001BW0 3J", "&#919;", "\u0397", "E", "E", "E", "ETA MAIU" },
				{ "\u001BW0 3j", "&#951;", "\u03B7", "e", "e", "E", "ETA MIN" },
				{ "\u001BW0 3K", "&#920;", "\u0398", "Th", "Th", "TH", "TETA MAIU" },
				{ "\u001BW0 3k", "&#952;", "\u03B8", "th", "th", "TH", "TETA MIN" },
				{ "\u001BW0 3L", "&#921;", "\u0399", "I", "I", "I", "IOTA MAIU" },
				{ "\u001BW0 3l", "&#953;", "\u03B9", "i", "i", "I", "IOTA MIN" },
				{ "\u001BW0 3M", "&#922;", "\u039A", "K", "K", "K", "KAPPA MAIU" },
				{ "\u001BW0 3m", "&#954;", "\u03BA", "k", "k", "K", "KAPPA MIN" },
				{ "\u001BW0 3N", "&#923;", "\u039B", "L", "L", "L", "LAMBDA MAIU" },
				{ "\u001BW0 3n", "&#955;", "\u03BB", "l", "l", "L", "LAMBDA MIN" },
				{ "\u001BW0 3O", "&#924;", "\u039C", "M", "M", "M", "MI MAIU" },
				{ "\u001BW0 3o", "&#956;", "\u03BC", "m", "m", "M", "MI MIN" },
				{ "\u001BW0 3P", "&#925;", "\u039D", "N", "N", "N", "NI MAIU" },
				{ "\u001BW0 3p", "&#957;", "\u03BD", "n", "n", "N", "NI MIN" },
				{ "\u001BW0 3Q", "&#926;", "\u039E", "X", "X", "X", "XI MAIU" },
				{ "\u001BW0 3q", "&#958;", "\u03BE", "x", "x", "X", "XI MIN" },
				{ "\u001BW0 3R", "&#927;", "\u039F", "O", "O", "O", "OMICRON MAIU" },
				{ "\u001BW0 3r", "&#959;", "\u03BF", "o", "o", "O", "OMICRON MIN" },
				{ "\u001BW0 3S", "&#928;", "\u03A0", "P", "P", "P", "PI MAIU" },
				{ "\u001BW0 3s", "&#960;", "\u03C0", "p", "p", "P", "PI MIN" },
				{ "\u001BW0 3T", "&#990;", "\u03DE", "90", "90", "90", "KOPPA MAIU" },
				{ "\u001BW0 3t", "&#991;", "\u03DF", "90", "90", "90", "KOPPA MIN" },
				{ "\u001BW0 3U", "&#929;", "\u03A1", "R", "R", "R", "RO MAIU" },
				{ "\u001BW0 3u", "&#961;", "\u03C1", "r", "r", "R", "RO MIN" },
				{ "\u001BW0 3V", "&#931;", "\u03A3", "S", "S", "S", "SIGMA MAIU" },
				{ "\u001BW0 3v", "&#963;", "\u03C3", "s", "s", "S", "SIGMA MIN" },
				{ "\u001BW0 3w", "&#962;", "\u03C2", "s", "s", "S", "SIGMA MIN FINALE" },
				{ "\u001BW0 3X", "&#932;", "\u03A4", "T", "T", "T", "TAU MAIU" },
				{ "\u001BW0 3x", "&#964;", "\u03C4", "t", "t", "T", "TAU MIN" },
				{ "\u001BW0 3Y", "&#933;", "\u03A5", "Y", "Y", "Y", "UPSILON MAIU" },
				{ "\u001BW0 3y", "&#965;", "\u03C5", "y", "y", "Y", "UPSILON MIN" },
				{ "\u001BW0 3Z", "&#934;", "\u03A6", "Ph", "Ph", "PH", "FI MAIU" },
				{ "\u001BW0 3z", "&#966;", "\u03C6", "ph", "ph", "PH", "FI MIN" },
				{ "\u001BW0 4", "&#8320;", "\u2080", "0", "0", "0", "0 SOTTOSCRITTO" },
				{ "\u001BW0 4!", "&#8321;", "\u2081", "1", "1", "1", "1 SOTTOSCRITTO" },
				{ "\u001BW0 4'", "&#8327;", "\u2087", "7", "7", "7", "7 SOTTOSCRITTO" },
				{ "\u001BW0 4\"", "&#8322;", "\u2082", "2", "2", "2", "2 SOTTOSCRITTO" },
				{ "\u001BW0 4(", "&#8328;", "\u2088", "8", "8", "8", "8 SOTTOSCRITTO" },
				{ "\u001BW0 4)", "&#8329;", "\u2089", "9", "9", "9", "9 SOTTOSCRITTO" },
				{ "\u001BW0 4*", "&#960;", "\u03C0", "p", "p", "P",						"PI (GRECO) ESPONENTE" },
				{ "\u001BW0 4&", "&#8326;", "\u2086", "6", "6", "6", "6 SOTTOSCRITTO" },
				{ "\u001BW0 4#", "&#8323;", "\u2083", "3", "3", "3", "3 SOTTOSCRITTO" },
				{ "\u001BW0 4%", "&#8325;", "\u2085", "5", "5", "5", "5 SOTTOSCRITTO" },
				{ "\u001BW0 4+", "&#967;", "\u03C7", "ch", "ch", "CH",						"CHI (GRECO) ESPONENTE" },
				{ "\u001BW0 4$", "&#8324;", "\u2084", "4", "4", "4", "4 SOTTOSCRITTO" },
				{ "\u001BW0 40", "&#8304;", "\u2070", "0", "0", "0",						"0 (zero) SOPRASCRITTO" },
				{ "\u001BW0 41", "&#185;", "\u00B9", "&#185;", "\u00B9", "1",						"1 SOPRASCRITTO" },
				{ "\u001BW0 42", "&#178;", "\u00B2", "&#178;", "\u00B2", "2",						"2 SOPRASCRITTO" },
				{ "\u001BW0 43", "&#179;", "\u00B3", "&#179;", "\u00B3", "3",						"3 SOPRASCRITTO" },
				{ "\u001BW0 44", "&#8308;", "\u2074", "4", "4", "4", "4 SOPRASCRITTO" },
				{ "\u001BW0 45", "&#8309;", "\u2075", "5", "5", "5", "5 SOPRASCRITTO" },
				{ "\u001BW0 46", "&#8310;", "\u2076", "6", "6", "6", "6 SOPRASCRITTO" },
				{ "\u001BW0 47", "&#8311;", "\u2077", "7", "7", "7", "7 SOPRASCRITTO" },
				{ "\u001BW0 48", "&#8312;", "\u2078", "8", "8", "8", "8 SOPRASCRITTO" },
				{ "\u001BW0 49", "&#8313;", "\u2079", "9", "9", "9", "9 SOPRASCRITTO" },
				{ "\u001BW0-0E", "&#8364;", "\u20AC", "EUR", "EUR", "*", "EURO SIGN" },
				{ "\u001BW1A0A", "&#192;", "\u00C0", "&#192;", "\u00C0", "A",						"A MAIU con ACCENTO GRAVE" },
				{ "\u001BW1A0a", "&#224;", "\u00E0", "&#224;", "\u00E0", "A",						"A MINU con ACCENTO GRAVE" },
				{ "\u001BW1A0E", "&#200;", "\u00C8", "&#200;", "\u00C8", "E",						"E MAIU con ACCENTO GRAVE" },
				{ "\u001BW1A0e", "&#232;", "\u00E8", "&#232;", "\u00E8", "E",						"E MINU con ACCENTO GRAVE" },
				{ "\u001BW1A0I", "&#204;", "\u00CC", "&#204;", "\u00CC", "I",						"I MAIU con ACCENTO GRAVE" },
				{ "\u001BW1A0O", "&#210;", "\u00D2", "&#210;", "\u00D2", "O",						"O MAIU con ACCENTO GRAVE" },
				{ "\u001BW1A0o", "&#242;", "\u00F2", "&#242;", "\u00F2", "O",						"O MINU con ACCENTO GRAVE" },
				{ "\u001BW1A0U", "&#217;", "\u00D9", "&#217;", "\u00D9", "U",						"U MAIU con ACCENTO GRAVE" },
				{ "\u001BW1A0u", "&#249;", "\u00F9", "&#249;", "\u00F9", "U",						"U MINU con ACCENTO GRAVE" },
				{ "\u001BW1A1u", "&#236;", "\u00EC", "&#236;", "\u00EC", "I",						"I MINU con ACCENTO GRAVE" },
//				{ "\u001BW1A1i", "&#236;", "\u00EC", "&#236;", "\u00EC", "I",						"I MINU con ACCENTO GRAVE" },
				{ "\u001BW1B0A", "&#193;", "\u00C1", "&#193;", "\u00C1", "A",						"A MAIU con ACCENTO ACUTO" },
				{ "\u001BW1B0a", "&#225;", "\u00E1", "&#225;", "\u00E1", "A",						"A MINU con ACCENTO ACUTO" },
				{ "\u001BW1B0C", "&#262;", "\u0106", "C", "C", "C",						"C MAIU con ACCENTO ACUTO" },
				{ "\u001BW1B0c", "&#263;", "\u0107", "c", "c", "C",						"C MINU con ACCENTO ACUTO" },
				{ "\u001BW1B0E", "&#201;", "\u00C9", "&#201;", "\u00C9", "E",						"E MAIU con ACCENTO ACUTO" },
				{ "\u001BW1B0e", "&#233;", "\u00E9", "&#233;", "\u00E9", "E",						"E MINU con ACCENTO ACUTO" },
				{ "\u001BW1B0g", "g&#769;", "\u01F5", "g", "g", "G",						"G MINU con ACCENTO ACUTO" },
				{ "\u001BW1B0I", "&#205;", "\u00CD", "&#205;", "\u00CD", "I",						"I MAIU con ACCENTO ACUTO" },
				{ "\u001BW1B0K", "K&#779;", "\u1E30", "K", "K", "K",						"K MAIU con ACCENTO ACUTO" },
				{ "\u001BW1B0k", "k&#769;", "\u1E31", "k", "k", "K",						"K MINU con ACCENTO ACUTO" },
				{ "\u001BW1B0L", "&#313;", "\u0139", "L", "L", "L",						"L MAIU con ACCENTO ACUTO" },
				{ "\u001BW1B0l", "&#314;", "\u013A", "l", "l", "L",						"L MINU con ACCENTO ACUTO" },
				{ "\u001BW1B0M", "M&#769;", "\u1E3E", "M", "M", "M",						"M MAIU con ACCENTO ACUTO" },
				{ "\u001BW1B0m", "m&#769;", "\u1E3F", "m", "m", "M",						"M MINU con ACCENTO ACUTO" },
				{ "\u001BW1B0N", "&#323;", "\u0143", "N", "N", "N",						"N MAIU con ACCENTO ACUTO" },
				{ "\u001BW1B0n", "&#324;", "\u0144", "n", "n", "N",						"N MINU con ACCENTO ACUTO" },
				{ "\u001BW1B0O", "&#211;", "\u00D3", "&#211;", "\u00D3", "O",						"O MAIU con ACCENTO ACUTO" },
				{ "\u001BW1B0o", "&#243;", "\u00F3", "&#243;", "\u00F3", "O",						"O MINU con ACCENTO ACUTO" },
				{ "\u001BW1B0P", "P&#769;", "\u1E54", "P", "P", "P",						"P MAIU con ACCENTO ACUTO" },
				{ "\u001BW1B0p", "p&#769;", "\u1E55", "p", "p", "P",						"P MINU con ACCENTO ACUTO" },
				{ "\u001BW1B0R", "&#340;", "\u0154", "R", "R", "R",						"R MAIU con ACCENTO ACUTO" },
				{ "\u001BW1B0r", "&#341;", "\u0155", "r", "r", "R",						"R MINU con ACCENTO ACUTO" },
				{ "\u001BW1B0S", "&#346;", "\u015A", "S", "S", "S",						"S MAIU con ACCENTO ACUTO" },
				{ "\u001BW1B0s", "&#347;", "\u015B", "s", "s", "S",						"S MINU con ACCENTO ACUTO" },
				{ "\u001BW1B0U", "&#218;", "\u00DA", "&#218;", "\u00DA", "U",						"U MAIU con ACCENTO ACUTO" },
				{ "\u001BW1B0u", "&#250;", "\u00FA", "&#250;", "\u00FA", "U",						"U MINU con ACCENTO ACUTO" },
				{ "\u001BW1B0W", "W&#769;", "\u1E82", "W", "W", "W",						"W MAIU con ACCENTO ACUTO" },
				{ "\u001BW1B0w", "w&#769;", "\u1E83", "w", "w", "W",						"W MINU con ACCENTO ACUTO" },
				{ "\u001BW1B0Y", "&#221;", "\u00DD", "&#221;", "\u00DD", "Y",						"Y MAIU con ACCENTO ACUTO" },
				{ "\u001BW1B0y", "&#253;", "\u00FD", "&#253;", "\u00FD", "Y",						"Y MINU con ACCENTO ACUTO" },
				{ "\u001BW1B0Z", "&#377;", "\u0179", "Z", "Z", "Z",						"Z MAIU con ACCENTO ACUTO" },
				{ "\u001BW1B0z", "&#378;", "\u017A", "z", "z", "Z",						"Z MINU con ACCENTO ACUTO" },
				{ "\u001BW1B1u", "&#237;", "\u00ED", "&#237;", "\u00ED", "I",						"I MINU con ACCENTO ACUTO" },
				{ "\u001BW1C0A", "&#194;", "\u00C2", "&#194;", "\u00C2", "A",						"A MAIU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0a", "&#226;", "\u00E2", "&#226;", "\u00E2", "A",						"A MINU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0C", "&#264;", "\u0108", "C", "C", "C",						"C MAIU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0c", "&#265;", "\u0109", "c", "c", "C",						"C MINU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0E", "&#202;", "\u00CA", "&#202;", "\u00CA", "E",						"E MAIU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0e", "&#234;", "\u00EA", "&#234;", "\u00EA", "E",						"E MINU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0G", "&#284;", "\u011C", "G", "G", "G",						"G MAIU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0g", "&#285;", "\u011D", "g", "g", "G",						"G MINU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0H", "&#292;", "\u0124", "H", "H", "H",						"H MAIU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0h", "&#293;", "\u0125", "h", "h", "H",						"H MINU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0I", "&#206;", "\u00CE", "&#206;", "\u00CE", "I",						"I MAIU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0J", "&#308;", "\u0134", "J", "J", "J",						"J MAIU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0j", "&#309;", "\u0135", "j", "j", "J",						"J MINU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0O", "&#212;", "\u00D4", "&#212;", "\u00D4", "O",						"O MAIU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0o", "&#244;", "\u00F4", "&#244;", "\u00F4", "O",						"O MINU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0S", "&#348;", "\u015C", "S", "S", "S",						"S MAIU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0s", "&#349;", "\u015D", "s", "s", "S",						"S MINU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0U", "&#219;", "\u00DB", "&#219;", "\u00DB", "U",						"U MAIU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0u", "&#251;", "\u00FB", "&#251;", "\u00FB", "U",						"U MINU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0W", "&#372;", "\u0174", "W", "W", "W",						"W MAIU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0w", "&#373;", "\u0175", "w", "w", "W",						"W MINU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0Y", "&#374;", "\u0176", "Y", "Y", "Y",						"Y MAIU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C0y", "&#375;", "\u0177", "y", "y", "Y",						"Y MINU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1C1u", "&#238;", "\u00EE", "&#238;", "\u00EE", "I",						"I MINU con ACCENTO CIRCONFLESSO" },
				{ "\u001BW1D0A", "&#195;", "\u00C3", "&#195;", "\u00C3", "A",						"A MAIU con TILDE" },
				{ "\u001BW1D0a", "&#227;", "\u00E3", "&#227;", "\u00E3", "A",						"A MINU con TILDE" },
				{ "\u001BW1D0I", "&#296;", "\u0128", "I", "I", "I", "I MAIU con TILDE" },
				{ "\u001BW1D0N", "&#209;", "\u00D1", "&#209;", "\u00D1", "N",						"N MAIU con TILDE" },
				{ "\u001BW1D0n", "&#241;", "\u00F1", "&#241;", "\u00F1", "N",						"N MINU con TILDE" },
				{ "\u001BW1D0O", "&#213;", "\u00D5", "&#213;", "\u00D5", "O",						"O MAIU con TILDE" },
				{ "\u001BW1D0o", "&#245;", "\u00F5", "&#245;", "\u00F5", "O",						"O MINU con TILDE" },
				{ "\u001BW1D0U", "&#360;", "\u0168", "U", "U", "U", "U MAIU con TILDE" },
				{ "\u001BW1D0u", "&#361;", "\u0169", "u", "u", "U", "U MINU con TILDE" },
				{ "\u001BW1D1u", "&#297;", "\u0129", "i", "i", "I", "I MINU con TILDE" },
				{ "\u001BW1E0A", "A&#773;", "\u0100", "A", "A", "A",						"A MAIU con LUNGA SOPRASCRITTA" },
				{ "\u001BW1E0a", "&#257;", "\u0101", "a", "a", "A",						"A MINU con LUNGA SOPRASCRITTA" },
				{ "\u001BW1E0E", "E&#772;", "\u0112", "E", "E", "E",						"E MAIU con LUNGA SOPRASCRITTA" },
				{ "\u001BW1E0e", "&#275;", "\u0113", "e", "e", "E",						"E MINU con LUNGA SOPRASCRITTA" },
				{ "\u001BW1E0G", "G&#773;", "\u1E20", "G", "G", "G",						"G MAIU con LUNGA SOPRASCRITTA" },
				{ "\u001BW1E0g", "g&#773;", "\u1E21", "g", "g", "G",						"G MINU con LUNGA SOPRASCRITTA" },
				{ "\u001BW1E0I", "I&#772;", "\u012A", "I", "I", "I",						"I MAIU con LUNGA SOPRASCRITTA" },
				{ "\u001BW1E0O", "O&#773;", "\u014C", "O", "O", "O",						"O MAIU con LUNGA SOPRASCRITTA" },
				{ "\u001BW1E0o", "&#333;", "\u014D", "o", "o", "O",						"O MINU con LUNGA SOPRASCRITTA" },
				{ "\u001BW1E0U", "U&#773;", "\u016A", "U", "U", "U",						"U MAIU con LUNGA SOPRASCRITTA" },
				{ "\u001BW1E0u", "&#363;", "\u016B", "u", "u", "U",						"U MINU con LUNGA SOPRASCRITTA" },
				{ "\u001BW1E1u", "&#299;", "\u012B", "i", "i", "I",						"I MINU con LUNGA SOPRASCRITTA" },
				{ "\u001BW1F0A", "&#258;", "\u0102", "A", "A", "A",						"A MAIU con BREVE SOPRASCRITTA" },
				{ "\u001BW1F0a", "&#259;", "\u0103", "a", "a", "A",						"A MINU con BREVE SOPRASCRITTA" },
				{ "\u001BW1F0E", "E&#774;", "\u0114", "E", "E", "E",						"E MAIU con BREVE SOPRASCRITTA" },
				{ "\u001BW1F0e", "&#277;", "\u0115", "e", "e", "E",						"E MINU con BREVE SOPRASCRITTA" },
				{ "\u001BW1F0G", "&#286;", "\u011E", "G", "G", "G",						"G MAIU con BREVE SOPRASCRITTA" },
				{ "\u001BW1F0g", "&#287;", "\u011F", "g", "g", "G",						"G MINU con BREVE SOPRASCRITTA" },
				{ "\u001BW1F0I", "&#300;", "\u012C", "I", "I", "I",						"I MAIU con BREVE SOPRASCRITTA" },
				{ "\u001BW1F0O", "O&#774;", "\u014E", "O", "O", "O",						"O MAIU con BREVE SOPRASCRITTA" },
				{ "\u001BW1F0o", "&#335;", "\u014F", "o", "o", "O",						"O MINU con BREVE SOPRASCRITTA" },
				{ "\u001BW1F0U", "&#362;", "\u016A", "U", "U", "U",						"U MAIU con BREVE SOPRASCRITTA" },
				{ "\u001BW1F0u", "&#365;", "\u016D", "u", "u", "U",						"U MINU con BREVE SOPRASCRITTA" },
				{ "\u001BW1F1u", "&#301;", "\u012D", "i", "i", "I",						"I MINU con BREVE SOPRASCRITTA" },
				{ "\u001BW1G0A", "A&#775;", "\u0226", "A", "A", "A",						"A MAIU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1G0a", "a&#775;", "\u0227", "a", "a", "A",						"A MINU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1G0C", "&#266;", "\u010A", "C", "C", "C",						"C MAIU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1G0c", "&#267;", "\u010B", "c", "c", "C",						"C MINU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1G0E", "&#278;", "\u0116", "E", "E", "E",						"E MAIU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1G0e", "&#279;", "\u0117", "e", "e", "E",						"E MINU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1G0F", "F&#775;", "\u1E1E", "F", "F", "F",						"F MAIU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1G0f", "f&#775;", "\u1E1F", "f", "f", "F",						"F MINU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1G0G", "&#288;", "\u0120", "G", "G", "G",						"G MAIU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1G0g", "&#289;", "\u0121", "g", "g", "G",						"G MINU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1G0I", "&#304;", "\u0130", "I", "I", "I",						"I MAIU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1G0m", "m&#775;", "\u1E40", "m", "m", "M",						"M MINU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1G0n", "n&#775;", "\u1E44", "n", "n", "N",						"N MINU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1G0Y", "Y&#775;", "\u1E8E", "Y", "Y", "Y",						"Y MAIU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1G0y", "y&#775;", "\u1E1F", "y", "y", "Y",						"Y MINU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1G0Z", "&#379;", "\u017B", "Z", "Z", "Z",						"Z MAIU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1G0z", "&#380;", "\u017C", "z", "z", "Z",						"Z MINU con PUNTO SOPRASCRITTO" },
				{ "\u001BW1H0A", "&#196;", "\u00C4", "&#196;", "\u00C4", "A",						"A MAIU con DIERESI" },
				{ "\u001BW1H0a", "&#228;", "\u00E4", "&#228;", "\u00E4", "A",						"A MINU con DIERESI" },
				{ "\u001BW1H0E", "&#203;", "\u00CB", "&#203;", "\u00CB", "E",						"E MAIU con DIERESI" },
				{ "\u001BW1H0e", "&#235;", "\u00EB", "&#235;", "\u00EB", "E",						"E MINU con DIERESI" },
				{ "\u001BW1H0I", "&#207;", "\u00CF", "&#207;", "\u00CF", "I",						"I MAIU con DIERESI" },
				{ "\u001BW1H0O", "&#214;", "\u00D6", "&#214;", "\u00D6", "O",						"O MAIU con DIERESI" },
				{ "\u001BW1H0o", "&#246;", "\u00F6", "&#246;", "\u00F6", "O",
						"O MINU con DIERESI" },
				{ "\u001BW1H0U", "&#220;", "\u00DC", "&#220;", "\u00DC", "U",
						"U MAIU con DIERESI" },
				{ "\u001BW1H0u", "&#252;", "\u00FC", "&#252;", "\u00FC", "U",
						"U MINU con DIERESI" },
				{ "\u001BW1H0Y", "&#376;", "\u0178", "Y", "Y", "Y",
						"Y MAIU con DIERESI" },
				{ "\u001BW1H0y", "&#376;", "\u0178", "y", "y", "Y",
						"Y MINU con DIERESI" },
				{ "\u001BW1H1u", "&#239;", "\u00EF", "&#239;", "\u00EF", "I",
						"I MINU con DIERESI" },
				{ "\u001BW1I0A", "A&#782;", "A\u030E", "&#196;", "\u00C4", "A",
						"A MAIU con UMLAUT" },
				{ "\u001BW1I0a", "a&#782;", "a\u030E", "&#228;", "\u00E4", "A",
						"A MINU con UMLAUT" },
				{ "\u001BW1I0E", "E&#782;", "E\u030E", "&#203;", "\u00CB", "E",
						"E MAIU con UMLAUT" },
				{ "\u001BW1I0e", "e&#782;", "e\u030E", "&#235;", "\u00EB", "E",
						"E MINU con UMLAUT" },
				{ "\u001BW1I0O", "O&#782;", "O\u030E", "&#214;", "\u00D6", "O",
						"O MAIU con UMLAUT" },
				{ "\u001BW1I0o", "o&#782;", "o\u030E", "&#246;", "\u00F6", "O",
						"O MINU con UMLAUT" },
				{ "\u001BW1I0U", "U&#782;", "U\u030E", "&#220;", "\u00DC", "U",
						"U MAIU con UMLAUT" },
				{ "\u001BW1I0u", "u&#782;", "u\u030E", "&#252;", "\u00FC", "U",
						"U MINU con UMLAUT" },
				{ "\u001BW1I0Y", "Y&#782;", "Y\u030E", "Y", "Y", "Y",
						"Y MAIU con UMLAUT" },
				{ "\u001BW1I0y", "y&#782;", "y\u030E", "&#255;", "\u00FF", "Y",
						"Y MINU con UMLAUT" },
				{ "\u001BW1J0A", "&#197;", "\u00C5", "&#197;", "\u00C5", "A",
						"A MAIU con CIRCOLETTO SOPRASCRITTO" },
				{ "\u001BW1J0a", "&#229;", "\u00E5", "&#229;", "\u00E5", "A",
						"A MINU con CIRCOLETTO SOPRASCRITTO" },
				{ "\u001BW1J0U", "&#366;", "\u016E", "U", "U", "U",
						"U MAIU con CIRCOLETTO SOPRASCRITTO" },
				{ "\u001BW1J0u", "&#367;", "\u016F", "u", "u", "U",
						"U MINU con CIRCOLETTO SOPRASCRITTO" },
				{ "\u001BW1K0l", "l&#789;", "\u013E", "l", "l", "L",
						"L MINU con VIRGOLA SOPRASCR. DECENTRATA" },
				{ "\u001BW1K0t", "&#357;", "\u0165", "t", "t", "T",
						"T MINU con VIRGOLA SOPRASCR. DECENTRATA" },
				{ "\u001BW1M0O", "&#336;", "\u0150", "O", "O", "O",
						"O MAIU con DOPPIO ACCENTO ACUTO" },
				{ "\u001BW1M0o", "&#337;", "\u0151", "o", "o", "O",
						"O MINU con DOPPIO ACCENTO ACUTO" },
				{ "\u001BW1M0U", "&#368;", "\u0170", "U", "U", "U",
						"U MAIU con DOPPIO ACCENTO ACUTO" },
				{ "\u001BW1M0u", "&#369;", "\u0171", "u", "u", "U",
						"U MINU con DOPPIO ACCENTO ACUTO" },
				{ "\u001BW1O0A", "&#461;", "\u01CD", "A", "A", "A",
						"A MAIU con PIPA (HACEK)" },
				{ "\u001BW1O0a", "&#462;", "\u01CE", "a", "a", "A",
						"A MINU con PIPA (HACEK)" },
				{ "\u001BW1O0C", "&#268;", "\u010C", "C", "C", "C",
						"C MAIU con PIPA (HACEK)" },
				{ "\u001BW1O0c", "&#269;", "\u010D", "c", "c", "C",
						"C MINU con PIPA (HACEK)" },
				{ "\u001BW1O0D", "&#270;", "\u010E", "D", "D", "D",
						"D MAIU con PIPA (HACEK)" },
				{ "\u001BW1O0d", "&#271;", "\u0010F", "d", "d", "D",
						"D MINU con PIPA (HACEK)" },
				{ "\u001BW1O0E", "&#282;", "\u011A", "E", "E", "E",
						"E MAIU con PIPA (HACEK)" },
				{ "\u001BW1O0e", "&#283;", "\u011B", "e", "e", "E",
						"E MINU con PIPA (HACEK)" },
				{ "\u001BW1O0G", "&#486;", "\u01E6", "G", "G", "G",
						"G MAIU con PIPA (HACEK)" },
				{ "\u001BW1O0g", "&#487;", "\u01E7", "g", "g", "G",
						"G MINU con PIPA (HACEK)" },
				{ "\u001BW1O0I", "I&#780;", "\u01CF", "I", "I", "I",
						"I MAIU con PIPA (HACEK)" },
				{ "\u001BW1O0K", "&#488;", "\u01E8", "K", "K", "K",
						"K MAIU con PIPA (HACEK)" },
				{ "\u001BW1O0k", "k&#780;", "\u01E9", "k", "k", "K",
						"K MINU con PIPA (HACEK)" },
				{ "\u001BW1O0L", "L&#780;", "\u013D", "L", "L", "L",
						"L MAIU con PIPA (HACEK)" },
				{ "\u001BW1O0l", "l&#780;", "\u013E", "l", "l", "L",
						"L MINU con PIPA (HACEK)" },
				{ "\u001BW1O0N", "&#327;", "\u0147", "N", "N", "N",
						"N MAIU con PIPA (HACEK)" },
				{ "\u001BW1O0n", "&#328;", "\u0148", "n", "n", "N",
						"N MINU con PIPA (HACEK)" },
				{ "\u001BW1O0R", "&#344;", "\u0158", "R", "R", "R",
						"R MAIU con PIPA (HACEK)" },
				{ "\u001BW1O0r", "&#345;", "\u0159", "r", "r", "R",
						"R MINU con PIPA (HACEK)" },
				{ "\u001BW1O0S", "&#352;", "\u0160", "S", "S", "S",
						"S MAIU con PIPA (HACEK)" },
				{ "\u001BW1O0s", "&#353;", "\u0161", "s", "s", "S",
						"S MINU con PIPA (HACEK)" },
				{ "\u001BW1O0T", "&#356;", "\u0164", "T", "T", "T",
						"T MAIU con PIPA (HACEK)" },
				{ "\u001BW1O0Z", "&#381;", "\u017D", "Z", "Z", "Z",
						"Z MAIU con PIPA (HACEK)" },
				{ "\u001BW1O0z", "&#382;", "\u017E", "z", "z", "Z",
						"Z MINU con PIPA (HACEK)" },
				{ "\u001BW1O1u", "&#464;", "\u01D0", "i", "i", "I",
						"I MINU con PIPA (HACEK)" },
				{ "\u001BW1P0C", "&#199;", "\u00C7", "&#199;", "\u00C7", "C",
						"C MAIU con CEDIGLIA" },
				{ "\u001BW1P0c", "&#231;", "\u00E7", "&#231;", "\u00E7", "C",
						"C MINU con CEDIGLIA" },
				{ "\u001BW1P0G", "&#290;", "\u0122", "G", "G", "G",
						"G MAIU con CEDIGLIA" },
				{ "\u001BW1P0K", "&#310;", "\u0136", "K", "K", "K",
						"K MAIU con CEDIGLIA" },
				{ "\u001BW1P0k", "&#311;", "\u0137", "k", "k", "K",
						"K MINU con CEDIGLIA" },
				{ "\u001BW1P0L", "&#315;", "\u013B", "L", "L", "L",
						"L MAIU con CEDIGLIA" },
				{ "\u001BW1P0l", "&#316;", "\u013C", "l", "l", "L",
						"L MINU con CEDIGLIA" },
				{ "\u001BW1P0N", "&#325;", "\u0145", "N", "N", "N",
						"N MAIU con CEDIGLIA" },
				{ "\u001BW1P0n", "&#326;", "\u0146", "n", "n", "N",
						"N MINU con CEDIGLIA" },
				{ "\u001BW1P0R", "&#342;", "\u0156", "R", "R", "R",
						"R MAIU con CEDIGLIA" },
				{ "\u001BW1P0r", "&#343;", "\u0157", "r", "r", "R",
						"R MINU con CEDIGLIA" },
				{ "\u001BW1P0S", "&#350;", "\u015E", "S", "S", "S",
						"S MAIU con CEDIGLIA" },
				{ "\u001BW1P0s", "&#351;", "\u015F", "s", "s", "S",
						"S MINU con CEDIGLIA" },
				{ "\u001BW1R0a", "a&#801;", "a\u0321", "a", "a", "A",
						"A MINU con GANCIO A SINISTRA" },
				{ "\u001BW1R0e", "e&#801;", "e\u0321", "e", "e", "E",
						"E MINU con GANCIO A SINISTRA" },
				{ "\u001BW1R0S", "S&#801;", "S\u0321", "S", "S", "S",
						"S MAIU con GANCIO A SINISTRA" },
				{ "\u001BW1R0s", "s&#801;", "s\u0321", "s", "s", "S",
						"S MINU con GANCIO A SINISTRA" },
				{ "\u001BW1R0T", "T&#801;", "T\u0321", "T", "T", "T",
						"T MAIU con GANCIO A SINISTRA" },
				{ "\u001BW1R0t", "t&#801;", "t\u0321", "t", "t", "T",
						"T MINU con GANCIO A SINISTRA" },
				{ "\u001BW1S0A", "&#260;", "\u0104", "A", "A", "A",
						"A MAIU con GANCIO A DESTRA" },
				{ "\u001BW1S0a", "&#261;", "\u0105", "a", "a", "A",
						"A MINU con GANCIO A DESTRA" },
				{ "\u001BW1S0E", "&#280;", "\u0118", "E", "E", "E",
						"E MAIU con GANCIO A DESTRA" },
				{ "\u001BW1S0e", "&#281;", "\u0119", "e", "e", "E",
						"E MINU con GANCIO A DESTRA" },
				{ "\u001BW1S0I", "&#302;", "\u012E", "I", "I", "I",
						"I MAIU con GANCIO A DESTRA" },
				{ "\u001BW1S0i", "&#303;", "\u012F", "i", "i", "I",
						"I MINU con GANCIO A DESTRA" },
				{ "\u001BW1S0U", "&#370;", "\u0172", "U", "U", "U",
						"U MAIU con GANCIO A DESTRA" },
				{ "\u001BW1S0u", "&#371;", "\u0173", "u", "u", "U",
						"U MINU con GANCIO A DESTRA" },
				{ "\u001BW1U0H", "H&#814;", "\u1E2A", "H", "H", "H",
						"H MAIU con BREVE SOTTOSCRITTA" },
				{ "\u001BW1U0h", "h&#814;", "\u1E2B", "h", "h", "H",
						"H MINU con BREVE SOTTOSCRITTA" },
				{ "\u001BW1V0d", "d&#803;", "\u1E0D", "d", "d", "D",
						"D MINU con PUNTO SOTTOSCRITTO" },
				{ "\u001BW1V0H", "H&#803;", "\u1E24", "H", "H", "H",
						"H MAIU con PUNTO SOTTOSCRITTO" },
				{ "\u001BW1V0h", "h&#803;", "\u1E25", "h", "h", "H",
						"H MINU con PUNTO SOTTOSCRITTO" },
				{ "\u001BW1V0m", "m&#803;", "\u1E43", "m", "m", "M",
						"M MINU con PUNTO SOTTOSCRITTO" },
				{ "\u001BW1V0n", "n&#803;", "\u1E47", "n", "n", "N",
						"N MINU con PUNTO SOTTOSCRITTO" },
				{ "\u001BW1V0r", "r&#803;", "\u1E5B", "r", "r", "R",
						"R MINU con PUNTO SOTTOSCRITTO" },
				{ "\u001BW1V0S", "S&#803;", "\u1E62", "S", "S", "S",
						"S MAIU con PUNTO SOTTOSCRITTO" },
				{ "\u001BW1V0s", "s&#803;", "\u1E63", "s", "s", "S",
						"S MINU con PUNTO SOTTOSCRITTO" },
				{ "\u001BW1V0T", "T&#803;", "\u1E6C", "T", "T", "T",
						"T MAIU con PUNTO SOTTOSCRITTO" },
				{ "\u001BW1V0t", "t&#803;", "\u1E6D", "t", "t", "T",
						"T MINU con PUNTO SOTTOSCRITTO" },
				{ "\u001BW1V0Z", "Z&#803;", "\u1E92", "Z", "Z", "Z",
						"Z MAIU con PUNTO SOTTOSCRITTO" },
				{ "\u001BW1V0z", "z&#803;", "\u1E93", "z", "z", "Z",
						"Z MINU con PUNTO SOTTOSCRITTO" },
				{ "\u001BW1X0a", "a&#817;", "a\u0331", "a", "a", "A",
						"A MINU con SOTTOLINEATURA" },
				{ "\u001BW1X0D", "D&#817;", "D\u0331", "D", "D", "D",
						"D MAIU con SOTTOLINEATURA" },
				{ "\u001BW1X0d", "d&#817;", "d\u0331", "d", "d", "D",
						"D MINU con SOTTOLINEATURA" },
				{ "\u001BW1X0H", "H&#817;", "H\u0331", "H", "H", "H",
						"H MAIU con SOTTOLINEATURA" },
				{ "\u001BW1X0h", "h&#817;", "h\u0331", "h", "h", "H",
						"H MINU con SOTTOLINEATURA" },
				{ "\u001BW1X0i", "i&#817;", "i\u0331", "i", "i", "I",
						"I MINU con SOTTOLINEATURA" },
				{ "\u001BW1X0K", "K&#817;", "K\u0331", "K", "K", "K",
						"K MAIU con SOTTOLINEATURA" },
				{ "\u001BW1X0k", "k&#817;", "k\u0331", "k", "k", "K",
						"K MINU con SOTTOLINEATURA" },
				{ "\u001BW1X0T", "T&#817;", "T\u0331", "T", "T", "T",
						"T MAIU con SOTTOLINEATURA" },
				{ "\u001BW1X0t", "t&#817;", "t\u0331", "t", "t", "T",
						"T MINU con SOTTOLINEATURA" },
				{ "\u001BW1X0Z", "Z&#817;", "Z\u0331", "Z", "Z", "Z",
						"Z MAIU con SOTTOLINEATURA" },
				{ "\u001BW1X0z", "z&#817;", "z\u0331", "z", "z", "Z",
						"Z MINU con SOTTOLINEATURA" } };
		return initSpeChar;
	}

	/**
	 * Questo metodo viene utilizzato per la conversione della stringa
	 * 
	 * @param testo
	 *          Stringa da convertire
	 * @return Stringa convertita
	 */
	public String convertString(String testo)
	{
		String ris = "";
		if (tipo==7)
		{
			for (int x = 0; x < initSpeChar.length; x++)
			{
				log.debug(initSpeChar[x][0]);
				testo = testo.replace(initSpeChar[x][0], initSpeChar[x][1]);
			}
			ris += testo;
		}
		else if (tipo==9)
		{
			for(int x=0; x<testo.length(); x++)
			{
				if (htInitSpeChar.containsKey(testo.substring(x,x+1)))
				{
					ris +=htInitSpeChar.get(testo.substring(x,x+1));
				}
				else
					ris += testo.substring(x,x+1);
			}
		}
		else
		{
			for (int x = 0; x < initSpeChar.length; x++)
			{
				if (initSpeChar[x][0] != null && (!initSpeChar[x][0].equals("")))
				{
					testo = testo.replace(initSpeChar[x][0], initSpeChar[x][1]);
				}
			}
			ris = testo;
		}
		return ris;
	}
}
