package hipster.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import hipster.controller.HipsterController;

public class HipsterPanel extends JPanel
{

	private HipsterController baseController;
	private SpringLayout baseLayout;
	private JComboBox<String> phraseComboBox;

	public HipsterPanel(HipsterController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		phraseComboBox = new JComboBox<String>();

		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
		
	}

	private void setupComboBox()
	{
		String[] phrases = baseController.getFirstHipster().getHipsterPhrases();
		DefaultComboBoxModel phraseModel = new DefaultComboBoxModel(phrases);
		phraseComboBox.setModel(phraseModel);
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.PINK);
		this.add(phraseComboBox);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, phraseComboBox, 48, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, phraseComboBox, 189, SpringLayout.WEST, this);
	}

	private void setupListeners()
	{
		phraseComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int red = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);
				int blue = (int) (Math.random() * 256);
				setBackground(new Color(red, green, blue));
				String updatedTitle = phraseComboBox.getSelectedItem().toString();
				baseController.getBaseFrame().setTitle(updatedTitle);
			}

		});
	}

	public HipsterController getBaseController()
	{
		return baseController;
	}
}
