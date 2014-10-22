
public abstract class CommandAbstract {

	private String command;
	
	public String getCommand() {
		return this.command;
	}
	
	public Response execute() {
		return new Response(this, this.getResponse());
	}
	
	protected void setCommand(String command) {
		this.command = command;
	}
	
	public abstract String getResponse();
}
