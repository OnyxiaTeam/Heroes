/**
 * This was meant to handle all the response data,,
 * but due to a lack of time to the deadline, unfortunately
 * the whole application outputs data
 * 
 * @author RoYaL
 *
 */
public class Response {

	private CommandAbstract cmd;
	private String response;

	public Response(CommandAbstract cmd, String response) {
		this.cmd = cmd;
		this.response = response;
	}

	public String getMessage() {
		return this.response;
	}

}
