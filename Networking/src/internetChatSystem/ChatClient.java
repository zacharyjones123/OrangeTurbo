package internetChatSystem;

import java.net.*;
import java.io.*;
import java.awt.*;

public class ChatClient extends Frame implements Runnable {
	
	protected DataInputStream i;
	protected DataOutputStream o;
	protected TextArea output;
	protected TextField input;
	protected Thread listener;
	
	@SuppressWarnings("deprecation")
	public ChatClient (String title, InputStream i, OutputStream o) {
		super(title);
		this.i = new DataInputStream (new BufferedInputStream(i));
		this.o = new DataOutputStream(new BufferedOutputStream(o));
		setLayout(new BorderLayout());
		add("Center", output = new TextArea());
		output.setEditable(false);
		add("South", input = new TextField());
		pack();
		setVisible(true);
		input.requestFocus();
		listener = new Thread(this);
		listener.start();
	}
	
	public void run() {
		try {
			while (true) {
				String line = i.readUTF();
				output.append(line + "\n");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			listener = null;
			input.setVisible(false);
			validate();
			try {
				o.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public boolean handleEvent(Event e) {
		if ((e.target == input) && (e.id == Event.ACTION_EVENT)) {
			try {
				o.writeUTF((String)e.arg);
				o.flush();
			} catch (IOException ex) {
				ex.printStackTrace();
				listener.stop();
			}
			input.setText("");
			return true;
		} else if ((e.target == this) && (e.id == Event.WINDOW_DESTROY)) {
			if (listener != null)
				listener.stop();
			hide();
			return true;
		}
		return super.handleEvent(e);
	}
	
	public static void main(String args[]) throws IOException {
		if (args.length != 2)
			throw new RuntimeException ("Syntax: ChatClient <host> <port>");
		Socket s = new Socket (args[0], Integer.parseInt(args[1]));
		new ChatClient("Chat " + args[0] + ":" + args[1],
				s.getInputStream(), s.getOutputStream());
	}
	
	

}
