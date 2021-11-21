package example.excepton;

public class GoodNotFoundException extends Throwable{
	public GoodNotFoundException(String message) {
		super(message);
	}
}
