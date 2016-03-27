package mx.randalf.charSpec;

import java.util.Hashtable;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;


class SpeChar
{

	/**
	 * Questa variabile viene utilizzata per loggare l'applicazione
	 */
	private Logger log = Logger.getLogger(SpeChar.class);

	/**
	 * In questa variabile vengono registrate le informazioni per la conversione
	 * da utente e chiave
	 */
	private Unicode2Key unicode2Key = new Unicode2Key();

	/**
	 * In questa variabile vengono registrate le informazioni per la conversione
	 * da utente e chiave
	 */
	private Iso88592Key iso88592Key = new Iso88592Key();
//	private Vector usr2key = new Vector();

	/**
	 * In questa variabile vengono registrate le informazioni per la conversione
	 * da sbn a 8859
	 */
	private Sbn2Unicode sbn2Unicode = new Sbn2Unicode();

	/**
	 * In questa variabile vengono registrate le informazioni per la conversione
	 * da 8859 a sbn
	 */
	private Unicode2Sbn unicode2Sbn = new Unicode2Sbn();

	/**
	 * In questa variabile vengono registrate le informazioni per la conversione
	 * da iccu a 8859
	 */
	private Hashtable<String, String> iccu28859 = new Hashtable<String, String>();

	/**
	 * Costruttore
	 */
	public SpeChar()
	{
		// Valorizzo la variabile necessaria per la conversione dal formato ICCU al
		// formato ISO 8859

		iccu28859.put("0 1!", "*");
		iccu28859.put("0 1\"", "*");
		iccu28859.put("0 1#", " ");
		iccu28859.put("0 1$", " ");
		iccu28859.put("0 1%", " ");
		iccu28859.put("0 1&", " ");
		iccu28859.put("0 1'", "*");
		iccu28859.put("0 1(", "'");
		iccu28859.put("0 1)", "*");
		iccu28859.put("0 1+", "*");
		iccu28859.put("0 1,", "B");
		iccu28859.put("0 1-", "C");
		iccu28859.put("0 1.", "P");
		iccu28859.put("0 1/", "R");
		iccu28859.put("0 10", "*");
		iccu28859.put("0 11", "*");
		iccu28859.put("0 12", ",");
		iccu28859.put("0 16", " ");
		iccu28859.put("0 17", "*");
		iccu28859.put("0 18", "\"");
		iccu28859.put("0 19", "*");
		iccu28859.put("0 1;", "*");
		iccu28859.put("0 1=", "*");
		iccu28859.put("0 1>", "*");
		iccu28859.put("0 1?", "*");
		iccu28859.put("0 1a", "AE");
		iccu28859.put("0 1b", "D");
		iccu28859.put("0 1f", "IJ");
		iccu28859.put("0 1h", "L");
		iccu28859.put("0 1i", "O");
		iccu28859.put("0 1j", "OE");
		iccu28859.put("0 1l", "TH");
		iccu28859.put("0 1q", "AE");
		iccu28859.put("0 1r", "D");
		iccu28859.put("0 1s", "D");
		iccu28859.put("0 1u", "I");
		iccu28859.put("0 1v", "IJ");
		iccu28859.put("0 1x", "L");
		iccu28859.put("0 1y", "O");
		iccu28859.put("0 1z", "OE");
		iccu28859.put("0 1{", "SS");
		iccu28859.put("0 1|", "TH");
		iccu28859.put("0 2\"", " ");
		iccu28859.put("0 20", " ");
		iccu28859.put("0 21", " ");
		iccu28859.put("0 22", "\\2");
		iccu28859.put("0 23", "\\3");
		iccu28859.put("0 24", "X");
		iccu28859.put("0 25", "[MM]");
		iccu28859.put("0 26", "*");
		iccu28859.put("0 27", "X");
		iccu28859.put("0 28", "-");
		iccu28859.put("0 2Q", "\\1");
		iccu28859.put("0 2T", "TM");
		iccu28859.put("0 2U", " ");
		iccu28859.put("0 2`", "OHM");
		iccu28859.put("0 2c", "A");
		iccu28859.put("0 2d", "H");
		iccu28859.put("0 2g", "L");
		iccu28859.put("0 2k", "O");
		iccu28859.put("0 2m", "T");
		iccu28859.put("0 2n", "N");
		iccu28859.put("0 2o", "N");
		iccu28859.put("0 2p", "K");
		iccu28859.put("0 2t", "H");
		iccu28859.put("0 2w", "L");
		iccu28859.put("0 2}", "T");
		iccu28859.put("0 2~", "N");
		iccu28859.put("AA", "A");
		iccu28859.put("BA", "A");
		iccu28859.put("CA", "A");
		iccu28859.put("DA", "A");
		iccu28859.put("EA", "A");
		iccu28859.put("FA", "A");
		iccu28859.put("GA", "A");
		iccu28859.put("HA", "A");
		iccu28859.put("IA", "A");
		iccu28859.put("JA", "A");
		iccu28859.put("OA", "A");
		iccu28859.put("SA", "A");
		iccu28859.put("BC", "C");
		iccu28859.put("CC", "C");
		iccu28859.put("GC", "C");
		iccu28859.put("OC", "C");
		iccu28859.put("PC", "C");
		iccu28859.put("OD", "D");
		iccu28859.put("XD", "D");
		iccu28859.put("AE", "E");
		iccu28859.put("BE", "E");
		iccu28859.put("CE", "E");
		iccu28859.put("EE", "E");
		iccu28859.put("FE", "E");
		iccu28859.put("GE", "E");
		iccu28859.put("HE", "E");
		iccu28859.put("IE", "E");
		iccu28859.put("OE", "E");
		iccu28859.put("SE", "E");
		iccu28859.put("GF", "F");
		iccu28859.put("CG", "G");
		iccu28859.put("EG", "G");
		iccu28859.put("FG", "G");
		iccu28859.put("GG", "G");
		iccu28859.put("OG", "G");
		iccu28859.put("PG", "G");
		iccu28859.put("CH", "H");
		iccu28859.put("UH", "H");
		iccu28859.put("VH", "H");
		iccu28859.put("XH", "H");
		iccu28859.put("AI", "I");
		iccu28859.put("BI", "I");
		iccu28859.put("CI", "I");
		iccu28859.put("DI", "I");
		iccu28859.put("EI", "I");
		iccu28859.put("FI", "I");
		iccu28859.put("GI", "I");
		iccu28859.put("HI", "I");
		iccu28859.put("OI", "I");
		iccu28859.put("SI", "I");
		iccu28859.put("CJ", "J");
		iccu28859.put("BK", "K");
		iccu28859.put("OK", "K");
		iccu28859.put("PK", "K");
		iccu28859.put("XK", "K");
		iccu28859.put("BL", "L");
		iccu28859.put("OL", "L");
		iccu28859.put("PL", "L");
		iccu28859.put("BM", "M");
		iccu28859.put("BN", "N");
		iccu28859.put("DN", "N");
		iccu28859.put("ON", "N");
		iccu28859.put("PN", "N");
		iccu28859.put("AO", "O");
		iccu28859.put("BO", "O");
		iccu28859.put("CO", "O");
		iccu28859.put("DO", "O");
		iccu28859.put("EO", "O");
		iccu28859.put("FO", "O");
		iccu28859.put("HO", "O");
		iccu28859.put("IO", "O");
		iccu28859.put("MO", "O");
		iccu28859.put("BP", "P");
		iccu28859.put("BR", "R");
		iccu28859.put("OR", "R");
		iccu28859.put("PR", "R");
		iccu28859.put("BS", "S");
		iccu28859.put("CS", "S");
		iccu28859.put("OS", "S");
		iccu28859.put("RS", "S");
		iccu28859.put("VS", "S");
		iccu28859.put("OT", "T");
		iccu28859.put("RT", "T");
		iccu28859.put("VT", "T");
		iccu28859.put("XT", "T");
		iccu28859.put("AU", "U");
		iccu28859.put("BU", "U");
		iccu28859.put("CU", "U");
		iccu28859.put("DU", "U");
		iccu28859.put("EU", "U");
		iccu28859.put("FU", "U");
		iccu28859.put("HU", "U");
		iccu28859.put("IU", "U");
		iccu28859.put("JU", "U");
		iccu28859.put("MU", "U");
		iccu28859.put("SU", "U");
		iccu28859.put("BW", "W");
		iccu28859.put("CW", "W");
		iccu28859.put("BY", "Y");
		iccu28859.put("CY", "Y");
		iccu28859.put("GY", "Y");
		iccu28859.put("HY", "Y");
		iccu28859.put("IY", "Y");
		iccu28859.put("BZ", "Z");
		iccu28859.put("GZ", "Z");
		iccu28859.put("OZ", "Z");
		iccu28859.put("VZ", "Z");
		iccu28859.put("XZ", "Z");
		iccu28859.put("Aa", "A");
		iccu28859.put("Ba", "A");
		iccu28859.put("Ca", "A");
		iccu28859.put("Da", "A");
		iccu28859.put("Ea", "A");
		iccu28859.put("Fa", "A");
		iccu28859.put("Ga", "A");
		iccu28859.put("Ha", "A");
		iccu28859.put("Ia", "A");
		iccu28859.put("Ja", "A");
		iccu28859.put("Oa", "A");
		iccu28859.put("Ra", "A");
		iccu28859.put("Sa", "A");
		iccu28859.put("Xa", "A");
		iccu28859.put("Bc", "C");
		iccu28859.put("Cc", "C");
		iccu28859.put("Gc", "C");
		iccu28859.put("Oc", "C");
		iccu28859.put("Pc", "C");
		iccu28859.put("Od", "D");
		iccu28859.put("Vd", "D");
		iccu28859.put("Xd", "D");
		iccu28859.put("Ae", "E");
		iccu28859.put("Be", "E");
		iccu28859.put("Ce", "E");
		iccu28859.put("Ee", "E");
		iccu28859.put("Fe", "E");
		iccu28859.put("Ge", "E");
		iccu28859.put("He", "E");
		iccu28859.put("Ie", "E");
		iccu28859.put("Oe", "E");
		iccu28859.put("Re", "E");
		iccu28859.put("Se", "E");
		iccu28859.put("Gf", "F");
		iccu28859.put("Bg", "G");
		iccu28859.put("Cg", "G");
		iccu28859.put("Eg", "G");
		iccu28859.put("Fg", "G");
		iccu28859.put("Gg", "G");
		iccu28859.put("Og", "G");
		iccu28859.put("Ch", "H");
		iccu28859.put("Uh", "H");
		iccu28859.put("Vh", "H");
		iccu28859.put("Xh", "H");
		iccu28859.put("A1u", "I");
		iccu28859.put("B1u", "I");
		iccu28859.put("C1u", "I");
		iccu28859.put("D1u", "I");
		iccu28859.put("E1u", "I");
		iccu28859.put("F1u", "I");
		iccu28859.put("H1u", "I");
		iccu28859.put("O1u", "I");
		iccu28859.put("Si", "I");
		iccu28859.put("Xi", "I");
		iccu28859.put("Cj", "J");
		iccu28859.put("Bk", "K");
		iccu28859.put("Ok", "K");
		iccu28859.put("Pk", "K");
		iccu28859.put("Xk", "K");
		iccu28859.put("Bl", "L");
		iccu28859.put("Kl", "L");
		iccu28859.put("Ol", "L");
		iccu28859.put("Pl", "L");
		iccu28859.put("Bm", "M");
		iccu28859.put("Vm", "M");
		iccu28859.put("Bn", "N");
		iccu28859.put("Dn", "N");
		iccu28859.put("Gn", "N");
		iccu28859.put("On", "N");
		iccu28859.put("Pn", "N");
		iccu28859.put("Vn", "N");
		iccu28859.put("Ao", "O");
		iccu28859.put("Bo", "O");
		iccu28859.put("Co", "O");
		iccu28859.put("Do", "O");
		iccu28859.put("Eo", "O");
		iccu28859.put("Fo", "O");
		iccu28859.put("Ho", "O");
		iccu28859.put("Io", "O");
		iccu28859.put("Mo", "O");
		iccu28859.put("Bp", "P");
		iccu28859.put("Br", "R");
		iccu28859.put("Or", "R");
		iccu28859.put("Pr", "R");
		iccu28859.put("Vr", "R");
		iccu28859.put("Bs", "S");
		iccu28859.put("Cs", "S");
		iccu28859.put("Os", "S");
		iccu28859.put("Rs", "S");
		iccu28859.put("Vs", "S");
		iccu28859.put("Kt", "T");
		iccu28859.put("Rt", "T");
		iccu28859.put("Vt", "T");
		iccu28859.put("Xt", "T");
		iccu28859.put("Au", "U");
		iccu28859.put("Bu", "U");
		iccu28859.put("Cu", "U");
		iccu28859.put("Du", "U");
		iccu28859.put("Eu", "U");
		iccu28859.put("Fu", "U");
		iccu28859.put("Hu", "U");
		iccu28859.put("Iu", "U");
		iccu28859.put("Ju", "U");
		iccu28859.put("Mu", "U");
		iccu28859.put("Su", "U");
		iccu28859.put("Bw", "W");
		iccu28859.put("Cw", "W");
		iccu28859.put("By", "Y");
		iccu28859.put("Cy", "Y");
		iccu28859.put("Gy", "Y");
		iccu28859.put("Hy", "Y");
		iccu28859.put("Iy", "Y");
		iccu28859.put("Bz", "Z");
		iccu28859.put("Gz", "Z");
		iccu28859.put("Oz", "Z");
		iccu28859.put("Vz", "Z");
		iccu28859.put("Xz", "Z");
		iccu28859.put("0 3A", "A");
		iccu28859.put("0 3B", "B");
		iccu28859.put("0 3D", "G");
		iccu28859.put("0 3E", "D");
		iccu28859.put("0 3F", "E");
		iccu28859.put("0 3G", "6");
		iccu28859.put("0 3H", "6");
		iccu28859.put("0 3I", "Z");
		iccu28859.put("0 3J", "E");
		iccu28859.put("0 3K", "TH");
		iccu28859.put("0 3L", "I");
		iccu28859.put("0 3M", "K");
		iccu28859.put("0 3N", "L");
		iccu28859.put("0 3O", "M");
		iccu28859.put("0 3P", "N");
		iccu28859.put("0 3Q", "X");
		iccu28859.put("0 3R", "O");
		iccu28859.put("0 3S", "P");
		iccu28859.put("0 3T", "90");
		iccu28859.put("0 3U", "R");
		iccu28859.put("0 3V", "S");
		iccu28859.put("0 3X", "T");
		iccu28859.put("0 3Y", "Y");
		iccu28859.put("0 3Z", "PH");
		iccu28859.put("0 3[", "CH");
		iccu28859.put("0 3\\", "PS");
		iccu28859.put("0 3]", "O");
		iccu28859.put("0 3\"", "9");
		iccu28859.put("0 3a", "A");
		iccu28859.put("0 3b", "B");
		iccu28859.put("0 3d", "G");
		iccu28859.put("0 3e", "D");
		iccu28859.put("0 3f", "E");
		iccu28859.put("0 3g", "6");
		iccu28859.put("0 3h", "6");
		iccu28859.put("0 3i", "Z");
		iccu28859.put("0 3j", "E");
		iccu28859.put("0 3k", "TH");
		iccu28859.put("0 3l", "I");
		iccu28859.put("0 3m", "K");
		iccu28859.put("0 3n", "L");
		iccu28859.put("0 3o", "M");
		iccu28859.put("0 3p", "N");
		iccu28859.put("0 3q", "X");
		iccu28859.put("0 3r", "O");
		iccu28859.put("0 3s", "P");
		iccu28859.put("0 3t", "90");
		iccu28859.put("0 3u", "R");
		iccu28859.put("0 3v", "S");
		iccu28859.put("0 3x", "T");
		iccu28859.put("0 3y", "Y");
		iccu28859.put("0 3z", "PH");
		iccu28859.put("0 3{", "CH");
		iccu28859.put("0 3|", "PS");
		iccu28859.put("0 3}", "O");
		iccu28859.put("0 3~", "9");
		iccu28859.put("0 4 ", "0");
		iccu28859.put("0 4!", "1");
		iccu28859.put("0 4\"", "2");
		iccu28859.put("0 4#", "3");
		iccu28859.put("0 4$", "4");
		iccu28859.put("0 4%", "5");
		iccu28859.put("0 4&", "6");
		iccu28859.put("0 4'", "7");
		iccu28859.put("0 4(", "8");
		iccu28859.put("0 4)", "9");
		iccu28859.put("0 40", "0");
		iccu28859.put("0 41", "1");
		iccu28859.put("0 42", "2");
		iccu28859.put("0 43", "3");
		iccu28859.put("0 44", "4");
		iccu28859.put("0 45", "5");
		iccu28859.put("0 46", "6");
		iccu28859.put("0 47", "7");
		iccu28859.put("0 48", "8");
		iccu28859.put("0 49", "9");
		iccu28859.put("0 4C", "C");
		iccu28859.put("0 4D", "D");
		iccu28859.put("0 4I", "I");
		iccu28859.put("0 4L", "L");
		iccu28859.put("0 4M", "M");
		iccu28859.put("0 4V", "V");
		iccu28859.put("0 4X", "X");
	}

	/**
	 * Questo metodo serve per la conversione del testo dal formati ICCU al
	 * formato ISO 8859, questa conversione viene utilizzata durante la
	 * conversione del record Unimarc
	 * 
	 * @param Frase
	 *          Testo da Convertire
	 * @return Testo convertito
	 */
	public String iccu2iso8859(String Frase)
	{
		int x = 0;
		String Risulta = "";
		String Testo = "";
		try
		{
			for (x = 0; x < Frase.length(); x++)
			{
				Testo = (String) iccu28859.get(Frase.substring(x, x + 4));
				if (Testo == null)
				{
					Risulta = Risulta.concat(Frase.substring(x, x + 1));
				}
				else
				{
					if (!Testo.equals("*"))
						Risulta += Testo;
					x = x + 3;
				}
			}
		}
		catch (StringIndexOutOfBoundsException SIOOExc)
		{
			Risulta = Risulta.concat(Frase.substring(x));
		}
		catch (Exception Exc)
		{
			log.error(Exc);
		}
		/*
		 * finally { Risulta = togliSpazi(Risulta); }
		 */

		return Risulta;
	}

	/**
	 * Questo metodo serve per la conversione del testo dal formato ISO 8859 nel
	 * formato sbn, questa conversione viene utilizzata quando viene generato il
	 * record Unimarc
	 * 
	 * @param Frase
	 *          Testo da convertire
	 * @return Testo convertito
	 */
	public String iso88592sbn(String testo)
	{
		try
		{
			testo = unicode2Sbn.convertString(testo);
//			testo = togliSpazi(testo);
		}
		catch (Exception Exc)
		{
			log.error(Exc);
		}
		return testo;
	}

	/**
	 * Questo metodo servr per la conversione del testo dal formato Unicode nel formato sbn
	 * 
	 * @param Frase
	 *          Testo da convertire
	 * @return Testo convertito
	 */
	public String unicode2sbn (String testo)
	{
		try
		{
			testo = unicode2Sbn.convertString(testo);
//			testo = togliSpazi(testo);
		}
		catch (Exception Exc)
		{
			log.error(Exc);
		}
		return testo;
	}

	/**
	 * Questo metodo viene utilizzato per la conversione del record unimarc che
	 * utilizza il formato sbn per la gestione dei caratteri Spaciali nel formato
	 * ISO 8859.
	 * 
	 * @param Frase
	 *          testo da convertire
	 * @return Restituisce il testo convertito
	 */
	public String sbn2iso8859(String Frase)
	{
		try
		{
			Frase = ConveString(Frase);
		}
		catch (Exception exc)
		{
			log.error(exc);
		}
		return Frase;
	}

	/**
	 * Questo metodo viene utilizzato per la generazione del camnpo chiave da un
	 * testo in formato ISO 8859
	 * 
	 * @param Frase
	 *          Testo da convertire
	 * @return Testo convertito
	 */
	public String usr2key(String Frase)
	{
		int pos;
		try
		{
			pos = Frase.indexOf("*");
			if (pos > -1)
			{
				Frase = Frase.substring(pos);
			}
			Frase = togliSpazi(NormString(Frase));
		}
		catch (Exception exc)
		{
			log.error(exc);
		}
		return Frase;
	}

	/**
	 * Questo metodo viene utilizzato per togliere tutti i doppi spazi presenti
	 * nella stringa
	 * 
	 * @param Frase
	 *          Testo da verificare
	 * @return Testo verificato
	 */
	private String togliSpazi(String Frase)
	{
		StringTokenizer Dividi;
		String Risulta = "";
		String Parola;
		try
		{
			Dividi = new StringTokenizer(Frase, " ");
			while (Dividi.hasMoreTokens())
			{
				Parola = (String) Dividi.nextToken();
				if (!Parola.trim().equals(""))
				{
					Risulta = Risulta.concat(Parola + " ");
				}
			}
		}
		catch (Exception exc)
		{
			log.error(exc);
		}
		return Risulta.trim();
	}

	/**
	 * Questo metodo viene utilizzato per la convesione del testo Marc in Unicode
	 * @param testo
	 * @return
	 */
	private String ConveString(String testo)
	{
		int x;
		int valore;
		int valore2;
		String Risulta = "";

		try
		{
			testo = sbn2Unicode.convertString(testo);
			for (x = 0; x < testo.length(); x++)
			{
				valore = new Character(testo.charAt(x)).hashCode();
				if (valore == 194)
				{
					valore2 = new Character(testo.charAt(x + 1)).hashCode();
					if (valore2 == 710)
						x++;
					else if (valore2 == 8240)
					{
						Risulta = Risulta.concat("*");
						x++;
					}
					else Risulta = Risulta.concat(testo.substring(x, x + 1));
				}
				else if (valore == 27)
				{
					if (testo.substring(x + 1, x + 2).equals("I"))
					{
						Risulta = Risulta.concat("*");
						x++;
					}
					else if (testo.substring(x + 1, x + 2).equals("H"))
					{
						x++;
					}
				}
				else
				{
					Risulta = Risulta.concat(testo.substring(x, x + 1));
				}
			}
		}
		catch (Exception exc)
		{
			log.error(exc);
		}
		return Risulta;
	}

	/**
	 * Questo metodo viene utilizzato per Normalizzare la Stringa
	 * 
	 * @param Frase
	 * 
	 */
	private String NormString(String testo)
	{
		try
		{
			testo=unicode2Key.convertString(testo);
			testo=iso88592Key.convertString(testo);
		}
		catch (Exception exc)
		{
			log.error(exc);
		}
		return testo.toUpperCase();
	}
}
