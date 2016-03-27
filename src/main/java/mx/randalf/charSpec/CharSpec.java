package mx.randalf.charSpec;

import java.util.Vector;

import mx.randalf.charSpec.exception.SyntaxException;


/**
 * Questa classe viene utilizzata per gestire la Normalizzazione delle Stringe
 * 
 * @author Randazzo Massimiliano
 * @serialData 04/05/2006
 * @version 0.1
 */
public class CharSpec
{

  /**
   * 
   */
  public CharSpec()
  {
    super();
  }

  public static String conveIsoToMarc(String testo)
  {
    SpeChar speChar = new SpeChar();
    testo = speChar.iso88592sbn(testo);
    return testo;
  }
  /**
   * Questo metodo viene utilizzato per normalizzare un testo provenente da un record 
   * Unimarc
   * @param testo Testo da normalizzare
   * @return Testo normalizzato
   */
  public static String conveMarc(String testo)
  {
    SpeChar speChar = new SpeChar();
    testo = speChar.sbn2iso8859(testo);
    testo = speChar.iccu2iso8859(testo);
    return testo;
  }

  public static String conveVarSearch(String testo) throws SyntaxException
  {
  	return conveVarSearch(testo, false);
  }

  public static String conveVarSearch(String testo, boolean leftTruncation) throws SyntaxException
  {
  	String ris = "";
  	String myTesto = "";
  	String myRis = "";
  	String myRis2 = "";
  	String myExt = "";
  	Vector<String> testi = null;
  	Vector<String> newTesti = null;
  	int pos1 = -1;
  	int pos2 = -1;

  	testi = new Vector<String>();
  	newTesti = new Vector<String>();
  	testo = testo.trim();
  	
  	while (testo.trim().length()>0)
  	{
  		pos1 = testo.indexOf(" ");
  		pos2 = testo.indexOf("\"");
  		if (pos1 == -1 && pos2==-1)
  		{
  			testi.add(testo);
  			testo = "";
  		}
  		else
  		{
  			if (pos1>-1 && pos2==-1)
  			{
  				testi.add(testo.substring(0,pos1));
  				testo = testo.substring(pos1+1);
  			}
  			else if (pos1==-1 && pos2>-1)
  			{
  				if (pos2>0)
  				{
  					testi.add(testo.substring(0, pos2));
  					testo = testo.substring(pos2);
  				}
  				pos2 = testo.indexOf("\"", 1);
  				if (pos2==-1)
  					throw new SyntaxException("Stringa di ricerca non corretta");
  				myTesto = testo.substring(0, pos2+1);
  				testo = testo.substring(pos2+1);
  				if (testo.length()>0)
  				{
    				if (testo.substring(0,1).equals("\u007E"))
    				{
      				pos2 = testo.indexOf(" ", 1);
      				if (pos2== -1)
      				{
      					myTesto += testo;
      					testo = "";
      				}
      				else
      				{
      					myTesto += testo.substring(0, pos2);
        				testo = testo.substring(pos2+1);
      				}
    				}
    				else if (testo.substring(0,1).equals("^"))
    				{
      				pos2 = testo.indexOf(" ", 1);
      				if (pos2== -1)
      				{
      					myTesto += testo;
      					testo = "";
      				}
      				else
      				{
      					myTesto += testo.substring(0, pos2);
        				testo = testo.substring(pos2+1);
      				}
    				}
  				}
					testi.add(myTesto);
  			}
  			else if (pos1<pos2)
  			{
  				testi.add(testo.substring(0,pos1));
  				testo = testo.substring(pos1+1);
  			}
  			else
  			{
  				if (pos2>0)
  				{
  					testi.add(testo.substring(0, pos2));
  					testo = testo.substring(pos2);
  				}
  				pos2 = testo.indexOf("\"", 1);
  				if (pos2==-1)
  					throw new SyntaxException("Stringa di ricerca non corretta");
  				myTesto = testo.substring(0, pos2+1);
  				testo = testo.substring(pos2+1);
  				if (testo.length()>0)
  				{
    				if (testo.substring(0,1).equals("\u007E"))
    				{
      				pos2 = testo.indexOf(" ", 1);
      				if (pos2== -1)
      				{
      					myTesto += testo;
      					testo = "";
      				}
      				else
      				{
      					myTesto += testo.substring(0, pos2);
        				testo = testo.substring(pos2+1);
      				}
    				}
    				else if (testo.substring(0,1).equals("^"))
    				{
      				pos2 = testo.indexOf(" ", 1);
      				if (pos2== -1)
      				{
      					myTesto += testo;
      					testo = "";
      				}
      				else
      				{
      					myTesto += testo.substring(0, pos2);
        				testo = testo.substring(pos2+1);
      				}
    				}
  				}
					testi.add(myTesto);
  			}
  		}
  	}
  	
  	for (int x=0; x<testi.size(); x++)
  	{
  		if (!StopList.checkStopList((String)testi.get(x)))
  			newTesti.add(testi.get(x));
  	}
  	testi = newTesti;
  	for (int x=0; x<testi.size(); x++)
  	{
  		myTesto = (String)testi.get(x);
  		ris += ris.equals("")? "": " ";

  		if (myTesto.startsWith("\""))
  		{
  			myRis = "";
  			pos1=myTesto.lastIndexOf("\"");
  			if (myTesto.length()>pos1)
  			{
  				myExt = myTesto.substring(pos1+1);
  				myTesto = myTesto.substring(0,pos1);
  			}
  			while(myTesto.length()>0)
  			{
    			pos1 = myTesto.indexOf("*");
    			if (pos1==-1)
    			{
    				myRis += conveVar(myTesto,false);
    				myTesto= "";
    			}
    			else
    			{
    				myRis += conveVar(myTesto.substring(0,pos1),false)+"*";
    				myTesto = myTesto.substring(pos1+1);
    			}
  			}
  			ris += "\""+myRis+"\""+myExt;
  		}
  		else
  		{
  			myRis = "";
  			myRis2 = "";
  			while(myTesto.length()>0)
  			{
  				if (myTesto.substring(0,1).equals("*") || myTesto.substring(0,1).equals("?"))
  				{
  					if (!myRis2.equals(""))
  						myRis += conveVar(myRis2);
  					myRis2="";
  					myRis += myTesto.substring(0,1);
  				}
  				else if (myTesto.substring(0,1).equals("\u007E"))
  				{
  					if (myTesto.length()==1)
  					{
    					if (!myRis2.equals(""))
    						myRis += conveVar(myRis2);
    					myRis2="";
    					myRis += myTesto.substring(0,1);
  					}
  					else if (myTesto.substring(1,2).equals("0") || myTesto.substring(1,2).equals("1"))
  					{
    					if (!myRis2.equals(""))
    						myRis += conveVar(myRis2);
    					myRis2="";
    					myRis += myTesto;
    					myTesto = " ";
  					}
  					else
    					myRis2 += myTesto.substring(0,1);
  				}
  				else if (myTesto.substring(0,1).equals("^"))
  				{
  					if (myTesto.length()==1)
  					{
    					if (!myRis2.equals(""))
    						myRis += conveVar(myRis2);
    					myRis2="";
    					myRis += myTesto.substring(0,1);
  					}
  					else if (myTesto.substring(1,2).hashCode()>47 && myTesto.substring(1,2).hashCode()<58)
  					{
    					if (!myRis2.equals(""))
    						myRis += conveVar(myRis2);
    					myRis2="";
    					myRis += myTesto;
    					myTesto = " ";
  					}
  					else
    					myRis2 += myTesto.substring(0,1);
  				}
  				else
  					myRis2 += myTesto.substring(0,1);
  				myTesto = myTesto.substring(1);
  			}
				if (!myRis2.equals(""))
					myRis += conveVar(myRis2);
  			if (!myRis.equals("*") && !myRis.equals("?"))
  			{
	  			if (myRis.startsWith("*") || myRis.startsWith("?"))
	  			{
	  				if (leftTruncation)
	  				{
		  				ris +="(";
	  					ris += myRis.substring(1);
		  				for (int y=65; y<91; y++)
		  				{
		  					ris += " OR "+(char)y+myRis;
		  				}
		  				ris+=")";
	  				}
	  				else
	  					throw new SyntaxException("Non e' possbile la ricerca con troncamento a Sinistra");
	  			}
	  			else
	  				ris += myRis;
  			}
  		}
  	}
  	return ris;
  }
  
  public static String conveVarSearch_old(String testo, boolean leftTruncation) throws SyntaxException
  {
  	String ris = "";
  	String myTesto = "";
  	String myRis = "";
  	Vector<String> testi = null;
  	int pos1 = -1;
  	int pos2 = -1;

  	testi = new Vector<String>();
  	testo = testo.trim();
  	
  	while (testo.trim().length()>0)
  	{
  		pos1 = testo.indexOf(" ");
  		pos2 = testo.indexOf("\"");
  		if (pos1 == -1 && pos2==-1)
  		{
  			testi.add(testo);
  			testo = "";
  		}
  		else
  		{
  			if (pos1>-1 && pos2==-1)
  			{
  				testi.add(testo.substring(0,pos1));
  				testo = testo.substring(pos1+1);
  			}
  			else if (pos1==-1 && pos2>-1)
  			{
  				if (pos2>0)
  				{
  					testi.add(testo.substring(0, pos2));
  					testo = testo.substring(pos2);
  				}
  				pos2 = testo.indexOf("\"", 1);
  				if (pos2==-1)
  					throw new SyntaxException("Stringa di ricerca non corretta");
  				testi.add(testo.substring(0, pos2+1));
  				testo = testo.substring(pos2+1);
  			}
  			else if (pos1<pos2)
  			{
  				testi.add(testo.substring(0,pos1));
  				testo = testo.substring(pos1+1);
  			}
  			else
  			{
  				if (pos2>0)
  				{
  					testi.add(testo.substring(0, pos2));
  					testo = testo.substring(pos2);
  				}
  				pos2 = testo.indexOf("\"", 1);
  				if (pos2==-1)
  					throw new SyntaxException("Stringa di ricerca non corretta");
  				testi.add(testo.substring(0, pos2+1));
  				testo = testo.substring(pos2+1);
  			}
  		}
  	}
  	
  	for (int x=0; x<testi.size(); x++)
  	{
  		myTesto = (String)testi.get(x);
  		ris += ris.equals("")? "": " ";

  		if (myTesto.startsWith("\""))
  		{
  			System.out.println(myTesto);
  			myRis = "";
  			while(myTesto.length()>0)
  			{
    			pos1 = myTesto.indexOf("*");
    			if (pos1==-1)
    			{
    				myRis += conveVar(myTesto,false);
    				myTesto= "";
    			}
    			else
    			{
    				myRis += conveVar(myTesto.substring(0,pos1),false)+"*";
    				myTesto = myTesto.substring(pos1+1);
    			}
  			}
  			ris += "\""+myRis+"\"";
  		}
  		else
  		{
  			myRis = "";
  			while(myTesto.length()>0)
  			{
    			pos1 = myTesto.indexOf("*");
    			if (pos1==-1)
    			{
    				myRis += conveVar(myTesto,false);
    				myTesto= "";
    			}
    			else
    			{
    				myRis += conveVar(myTesto.substring(0,pos1),false)+"*";
    				myTesto = myTesto.substring(pos1+1);
    			}
  			}
  			if (!myRis.equals("*"))
  			{
	  			if (myRis.startsWith("*"))
	  			{
	  				if (leftTruncation)
	  				{
		  				ris +="(";
	  					ris += myRis.substring(1);
		  				for (int y=65; y<91; y++)
		  				{
		  					ris += " OR "+(char)y+myRis;
		  				}
		  				ris+=")";
	  				}
	  				else
	  					throw new SyntaxException("Non e' possbile la ricerca con troncamento a Sinistra");
	  			}
	  			else
	  				ris += myRis;
  			}
  		}
  	}
  	return ris;
  }
  
  public static String conveVarSearch_old(String testo )
  {
  	String ris = "";
  	int pos = 0;
  	int pos2 = 0;
  	boolean check = true;
  	while (testo.length()>0)
  	{
  		pos = testo.indexOf("*");
  		pos2 = testo.indexOf("\"");
  		if (pos == -1 && pos2 == -1)
  		{
  			check = testo.startsWith(" ");
  			ris += (ris.equals("")?"":(testo.startsWith(" ")?" ":""))+conveVar(testo,true);
  			testo = "";
  		}
  		else
  		{
  			if (pos >-1 && (pos<pos2 || pos2==-1))
  			{
    			check = testo.startsWith(" ");
    			ris += (ris.equals("")?"":ris.endsWith("\"")?"":(testo.startsWith(" ")?" ":""))+conveVar(testo.substring(0,pos), check)+"*";
    			testo = testo.substring(pos+1);
  			}
  			else
  			{
    			check = testo.startsWith(" ");
    			ris += (ris.equals("")?"":(testo.startsWith(" ")?" ":""))+conveVar(testo.substring(0,pos2),check)+"\"";
    			testo = testo.substring(pos2+1);
  			}
  		}
  	}
  	System.out.println("ConveVarSearch: "+ris.trim());
  	return ris.trim();
  }

  public static String conveVar(String testo)
  {
  	return conveVar(testo, true);
  }
  /**
   * Queta classe viene utilizzata per la normalizzazione delle stringe
   * necessarie per gli indici e gli ordinamenti
   * 
   * @param testo
   * 
   */
  public static String conveVar(String testo, boolean checkStopList)
  {
    int pos = 0;
    int pos1 = 0;
    String parola = "";
    SpeChar speChar = new SpeChar();

    pos = testo.indexOf("*");
    if (pos == -1)
    {
      pos = testo.indexOf(" ");
      if (pos > -1)
        parola = testo.substring(0, pos).trim();
      
      pos1 = testo.indexOf("'");
      if (pos1>-1 && (pos==-1 ||pos1<pos))
        parola=testo.substring(0,pos1+1);

      if(!parola.equals("") && checkStopList)
        if (StopList.checkStopList(parola))
          testo = testo.substring(parola.length()).trim();
    }
    else
    	testo = testo.substring(pos+1);
    testo = speChar.usr2key(testo);
    return checkPunteggiatura(testo);
  }

  private static String checkPunteggiatura(String testo)
  {
  	String ris = "";
  	int nChar = -1;
  	
  	for (int x =0; x<testo.length(); x++)
  	{
  		nChar = testo.substring(x,x+1).hashCode();
  		if ((nChar>=65 && nChar<=90) || nChar == 32 || (nChar>=48 && nChar<=57))
  		{
  			ris += testo.charAt(x);
  		}
  		else if (nChar==47 )
  		{
  			ris += " ";
  		}
  	}
  	ris = ris.replace("  ", " ").trim();
  	return ris;
  }
  /**
   * Questo metodo viene utilizzato per generare la chiave normalizzata per la
   * segnatura bibliografica
   * 
   * @param segnatura
   * 
   */
  public static String conveSegna(String segnatura)
  {
    String ris = "";
    String numero = "";
    int nChar = 0;
    Character myChar = null;
    segnatura = segnatura.toUpperCase();
    for (int x = 0; x < segnatura.length(); x++)
    {
      myChar = new Character(segnatura.charAt(x));
      nChar = myChar.hashCode();
      if ((nChar > 64 && nChar < 91) || nChar == 95 || nChar == 45)
      {
        if (!numero.equals(""))
          ris += mettiZeri(numero);

        if (nChar == 45)
          ris += "_";
        else
          ris += segnatura.charAt(x);
        numero = "";
      }
      else if (nChar > 47 && nChar < 58)
        numero += segnatura.charAt(x);
      else
      {
        if (!numero.equals(""))
          ris += mettiZeri(numero);

        if (!ris.endsWith(" "))
          ris += " ";
        numero = "";
      }
    }
    if (!numero.equals(""))
      ris += mettiZeri(numero);
    return ris;
  }

  /**
   * Questo metodo viene utilizzato per mettere degli zeri davanti al numero in
   * modo da arrivare ad un totale di 6 varatteri
   * 
   * @param valore
   * 
   */
  private static String mettiZeri(String valore)
  {
    while (valore.length() < 6)
    {
      valore = "0" + valore;
    }
    return valore;
  }

  /**
   * Questo metodo viene utilizzato per mettere degli zeri davanti al numeri indicato
   * 
   * @param valore Numero da normalizzare
   * @param num Numero di caratteri di cui deve essere lunga la stringa di risposta
   * @return Valore normalizzato
   */
  public static String mettiZeri(String valore, int num)
  {
    while (valore.length() < num)
    {
      valore = "0" + valore;
    }
    return valore;
  }

  /**
   * Questo metodo viene utilizzato per analizzare la stopList su un testo
   * 
   * @param testo Testo da Analizzare
   * @return Testo Analizzato
   */
  public static String checkStopList(String testo)
  {
  	int pos = 0;
  	int pos1 = 0;
  	String parola = "";
  	
  	testo = testo.toLowerCase();
  	
    pos = testo.indexOf("*");
    if (pos == -1)
    {
      pos = testo.indexOf(" ");
      if (pos > -1)
        parola = testo.substring(0, pos).trim();

      pos1 = testo.indexOf("'");
      if (pos1>-1 && (pos==-1 ||pos1<pos))
        parola=testo.substring(0,pos1+1);
      if(!parola.equals(""))
        if (StopList.checkStopList(parola))
          testo = testo.substring(parola.length()).trim();
    }
    else
    	testo = testo.substring(pos+1);

    return testo;
  }
}
