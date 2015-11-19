package hipster.view;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

import hipster.controller.HipsterController;

public class HipsterFrame extends JFrame
{
	private HipsterPanel basePanel;
	private HipsterController baseController;

	public HipsterFrame(HipsterController baseController)
	{
		this.baseController = baseController;
		basePanel = new HipsterPanel(baseController);
		setupFrame();
	}

	public String getResponse(String prompt)
	{
		String response = JOptionPane.showInputDialog(this, prompt);
		return response;
	}

	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(400, 400);
		this.setVisible(true);
	}

}
