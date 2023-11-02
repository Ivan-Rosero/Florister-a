package org.example.flowers;

import org.example.models.Product;
import org.example.models.Values;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FormIntellij extends JFrame{
    private static final long serialVersionUID = 4528133805175117510L;
    List<Product> productList = new ArrayList<Product>();
    private JPanel panel1;
    private JLabel informativeText;
    private JLabel informativeText2;
    private JCheckBox SFCheckBox;
    private JCheckBox TulipCheckBox;
    private JCheckBox CamaloteCheckBox;
    private JCheckBox RosesCheckBox;
    private JCheckBox CarnationsCheckBox;
    private JSpinner spinnerSF;
    private JSpinner spinnerRoses;
    private JSpinner spinnerCamalote;
    private JSpinner spinnerCarnation;
    private JSpinner spinnerTulip;
    private JButton enviarButton;
    private JRadioButton northButton;
    private JRadioButton southButton;

    public void SetUpComponent(Component com) {
        com.setPreferredSize(new Dimension(300,50));
        com.setFont(new Font("Lato",0,18));
    }

    public JSpinner SetUpSpinner() {
        int min = 0;
        int max = 100;
        int step = 1;
        int initValue = 0;
        SpinnerModel model = new SpinnerNumberModel(initValue, min, max, step);
        JSpinner spinner = new JSpinner(model);
        spinner.setPreferredSize(new Dimension(100,30));
        return spinner;
    }

    public FormIntellij() {
        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(500, 950));
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER,5,18));

        ButtonGroup zoneGroup = new ButtonGroup();

        northButton = new JRadioButton("Zona norte");
        northButton.setSelected(true);
        southButton = new JRadioButton("Zona sur");

        zoneGroup.add(northButton);
        zoneGroup.add(southButton);

        northButton.setFont((new Font("Arial", 0, 18)));
        southButton.setFont((new Font("Arial", 0, 18)));

        TulipCheckBox = new JCheckBox("Tulipanes");
        SetUpComponent(TulipCheckBox);

        spinnerTulip = SetUpSpinner();

        CarnationsCheckBox = new JCheckBox("Claveles");
        SetUpComponent(CarnationsCheckBox);

        spinnerCarnation = SetUpSpinner();

        RosesCheckBox = new JCheckBox("Rosas");
        SetUpComponent(RosesCheckBox);

        spinnerRoses = SetUpSpinner();

        CamaloteCheckBox = new JCheckBox("Camalotes");
        SetUpComponent(CamaloteCheckBox);

        spinnerCamalote = SetUpSpinner();

        SFCheckBox = new JCheckBox("Girasoles");
        SetUpComponent(SFCheckBox);

        spinnerSF = SetUpSpinner();

        informativeText = new JLabel("Seleccione los productos y cantidad ");
        informativeText2 = new JLabel("               que desea comprar:              ");
        informativeText.setFont(new Font("Arial", 1, 20));
        informativeText2.setFont(new Font("Arial", 1, 20));

        panel1.add(informativeText);
        panel1.add(informativeText2);

        panel1.add(northButton);
        panel1.add(southButton);

        panel1.add(TulipCheckBox);
        panel1.add(spinnerTulip);

        panel1.add(SFCheckBox);
        panel1.add(spinnerSF);

        panel1.add(RosesCheckBox);
        panel1.add(spinnerRoses);

        panel1.add(CarnationsCheckBox);
        panel1.add(spinnerCarnation);

        panel1.add(CamaloteCheckBox);
        panel1.add(spinnerCamalote);


        enviarButton = new JButton("Enviar");


        enviarButton.setPreferredSize(new Dimension(150,40));

        panel1.add(enviarButton);

        this.setLayout(new BorderLayout());
        getContentPane().add(panel1,BorderLayout.NORTH);

        this.setPreferredSize(new Dimension(500, 650));
        this.setLocation(10, 10);
        pack();
        setVisible(true);
        enviarButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        productList = new ArrayList<>();
                        if (TulipCheckBox.isSelected()){
                            productList.add(new Product("Tulipanes", Double.parseDouble(Values.tulips[1]), Values.tulips[0], (int)spinnerTulip.getValue(), (northButton.isSelected()?Values.discount[0]:Values.discount[1])));
                        }
                        if (SFCheckBox.isSelected()){
                            productList.add(new Product("Girasol", Double.parseDouble(Values.sunflower[1]), Values.sunflower[0], (int)spinnerSF.getValue(), (northButton.isSelected()?Values.discount[0]:Values.discount[1])));
                        }
                        if (RosesCheckBox.isSelected()){
                            productList.add(new Product("Rosas", Double.parseDouble(Values.roses[1]), Values.roses[0], (int)spinnerRoses.getValue(), (northButton.isSelected()?Values.discount[0]:Values.discount[1])));
                        }
                        if (CarnationsCheckBox.isSelected()){
                            productList.add(new Product("Claveles", Double.parseDouble(Values.carnation[1]), Values.carnation[0], (int)spinnerCarnation.getValue(), (northButton.isSelected()?Values.discount[0]:Values.discount[1])));
                        }
                        if (CamaloteCheckBox.isSelected()){
                            productList.add(new Product("Camalotes", Double.parseDouble(Values.camalote[1]), Values.camalote[0], (int)spinnerCamalote.getValue(), (northButton.isSelected()?Values.discount[0]:Values.discount[1])));
                        }
                        BillForm billForm = new BillForm((ArrayList) productList, northButton.isSelected()?"Zona norte":"Zona sur");


                    }
                }
        );
        setVisible(true);
    }
}