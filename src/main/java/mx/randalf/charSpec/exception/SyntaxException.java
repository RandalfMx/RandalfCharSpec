/**
 * 
 */
package mx.randalf.charSpec.exception;

/**
 * @author massi
 *
 */
public class SyntaxException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1339161488855093877L;

	/**
	 * 
	 */
	public SyntaxException()
	{
	}

	/**
	 * @param message
	 */
	public SyntaxException(String message)
	{
		super(message);
	}

	/**
	 * @param cause
	 */
	public SyntaxException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SyntaxException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
