package hipster.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import hipster.model.Book;

import hipster.controller.HipsterController;

public class HipsterPanel extends JPanel
{

	private HipsterController baseController;
	private SpringLayout baseLayout;
	private JComboBox<String> phraseComboBox;
	private JLabel bookPageCountLabel;
	private JLabel bookAuthorLabel;
	private JLabel bookSubjectLabel;
	private JLabel bookTitleLabel;
	private JLabel bookPriceLabel;
	private JButton changeBookButton;
	private int maxClicks;
	private int startClicks;

	public HipsterPanel(HipsterController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		bookPageCountLabel = new JLabel("The page count");
		bookAuthorLabel = new JLabel("The author");
		bookPriceLabel = new JLabel("The price");
		bookSubjectLabel = new JLabel("The subject");
		bookTitleLabel = new JLabel("The title");
		changeBookButton = new JButton("Change Books");
		phraseComboBox = new JComboBox<String>();
		maxClicks = baseController.getFirstHipster().getHipsterBooks().length;
		startClicks = 0;

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
		this.add(bookPageCountLabel);
		this.add(bookAuthorLabel);
		this.add(bookSubjectLabel);
		this.add(bookTitleLabel);
		this.add(changeBookButton);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, bookPageCountLabel, 0, SpringLayout.WEST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.EAST, bookAuthorLabel, -121, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, phraseComboBox, 29, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, phraseComboBox, 49, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, changeBookButton, 16, SpringLayout.SOUTH, bookPageCountLabel);
		baseLayout.putConstraint(SpringLayout.WEST, changeBookButton, 0, SpringLayout.WEST, bookPageCountLabel);
		baseLayout.putConstraint(SpringLayout.WEST, bookTitleLabel, 261, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookTitleLabel, -215, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, bookAuthorLabel, 6, SpringLayout.SOUTH, bookTitleLabel);
		baseLayout.putConstraint(SpringLayout.EAST, bookSubjectLabel, -116, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, bookPageCountLabel, 11, SpringLayout.SOUTH, bookSubjectLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, bookSubjectLabel, 6, SpringLayout.SOUTH, bookAuthorLabel);
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

		changeBookButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Book[] tempBooks = baseController.getFirstHipster().getHipsterBooks();
				if (startClicks < maxClicks)
				{
					bookSubjectLabel.setText("Book subject: " + tempBooks[startClicks].getSubject());
					bookAuthorLabel.setText("Book author: " + tempBooks[startClicks].getAuthor());
					bookTitleLabel.setText("Book title: " + tempBooks[startClicks].getTitle());
					bookPageCountLabel.setText("Book pages: " + tempBooks[startClicks].getPageCount());
					bookPriceLabel.setText("Book price: " + tempBooks[startClicks].getPrice());
					startClicks++;
				}
				else
				{
					startClicks = 0;
					bookSubjectLabel.setText("Book subject: ");
					bookAuthorLabel.setText("Book author: ");
					bookTitleLabel.setText("Book title: ");
					bookPageCountLabel.setText("Book pages: ");
					bookPriceLabel.setText("Book price: ");
				}
			}
		});
	}

	public HipsterController getBaseController()
	{
		return baseController;
	}
}
