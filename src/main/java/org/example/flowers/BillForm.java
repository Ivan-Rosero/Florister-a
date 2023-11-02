package org.example.flowers;

import org.example.models.Product;
import org.example.models.Values;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public class BillForm extends JFrame {

    private DecimalFormat decimalFormat;
    private JPanel panelBill;
    private JLabel labelTulip;
    private JLabel labelSunflower;
    private JLabel labelRoses;
    private JLabel labelCarnations;
    private JLabel labelCamalote;

    private JLabel labelTotal;
    private JLabel labelSubTotal;
    private JLabel doubleDiscount;
    private JLabel dateBill;

    private JButton printButton;

    private double subTotal = 0.0;

    private double discountDouble = 0.0;

    private double total = 0.0;
    double subTotalArray[] = new double[5];

    public JLabel zoneString;
    public BillForm(ArrayList<Product> productArrayList, String zone) {
        this.setPreferredSize(new Dimension(1000, 520));
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        this.decimalFormat = new DecimalFormat("#,###.##");

        this.dateBill = new JLabel(new Date().toGMTString());

        this.zoneString = new JLabel();

        this.panelBill = new JPanel();
        this.panelBill.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.panelBill.setPreferredSize(new Dimension(600, 500));

        this.dateBill.setFont(new Font("Arial", 0, 18));
        this.dateBill.setPreferredSize(new Dimension(550, 40));

        this.labelTulip = new JLabel();
        this.labelTulip.setFont(new Font("Arial", 0, 18));
        this.labelTulip.setPreferredSize(new Dimension(550, 40));

        this.labelSunflower = new JLabel();
        this.labelSunflower.setFont((new Font("Arial", 0, 18)));
        this.labelSunflower.setPreferredSize(new Dimension(550, 40));

        this.labelRoses = new JLabel();
        this.labelRoses.setFont((new Font("Arial", 0, 18)));
        this.labelRoses.setPreferredSize(new Dimension(550, 40));

        this.labelCarnations = new JLabel();
        this.labelCarnations.setFont((new Font("Arial", 0, 18)));
        this.labelCarnations.setPreferredSize(new Dimension(550, 40));

        this.labelCamalote = new JLabel();
        this.labelCamalote.setFont((new Font("Arial", 0, 18)));
        this.labelCamalote.setPreferredSize(new Dimension(550, 40));


        this.labelCamalote.setFont((new Font("Arial", 0, 18)));
        this.labelCamalote.setPreferredSize(new Dimension(550, 40));

        this.labelTotal = new JLabel();
        this.labelSubTotal = new JLabel();
        this.doubleDiscount = new JLabel();

        this.printButton = new JButton("Imprimir factura");
        this.printButton.setIcon(new ImageIcon(getUrlImagen("mail-icon.png")));
        this.printButton.setPreferredSize(new Dimension(80, 40));
        this.printButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                PrinterJob job=PrinterJob.getPrinterJob();
                job.setJobName("Print Data");

                job.setPrintable(new Printable(){
                    public int print(Graphics pg, PageFormat pf, int pageNum){
                        pf.setOrientation(PageFormat.LANDSCAPE);
                        if(pageNum>0){
                            return Printable.NO_SUCH_PAGE;
                        }

                        Graphics2D g2 = (Graphics2D)pg;
                        g2.translate(pf.getImageableX(), pf.getImageableY());
                        g2.scale(1,1);

                        panelBill.paint(g2);
                        return Printable.PAGE_EXISTS;
                    }
                });

                boolean ok = job.printDialog();
                if(ok){
                    try{

                        job.print();
                    }
                    catch (PrinterException ex){}
                }
            }
        });

        this.panelBill.add(dateBill);
        this.panelBill.add(labelTulip);
        this.panelBill.add(labelSunflower);
        this.panelBill.add(labelRoses);
        this.panelBill.add(labelCarnations);
        this.panelBill.add(labelCamalote);

        if(zone.contains("Zona norte")){
            this.zoneString.setText("Usted compro en " + zone +" y su descuento es de          " + Values.discount[0]+"%");
        }else{
            this.zoneString.setText("Usted compro en " + zone + " y su descuento es de             " + Values.discount[1]+"%");
        }

        panelBill.add(zoneString);

        this.zoneString.setPreferredSize(new Dimension(550, 40));
        this.zoneString.setFont((new Font("Arial", 1, 18)));
        this.panelBill.add(labelSubTotal);
        this.panelBill.add(doubleDiscount);
        this.panelBill.add(labelTotal);


        this.add(panelBill, BorderLayout.CENTER);
        this.add(printButton, BorderLayout.SOUTH);
        this.pack();


        for (Product p:productArrayList
             ) {
            if (p.getNameProduct()=="Tulipanes"){
                double partialTotal = p.getPrice() * p.getQuantity();
                subTotalArray[0] = partialTotal;
                this.labelTulip.setText("Compro los siguientes Tulipanes: "+ p.getQuantity() + " Y el precio es:           " + partialTotal);
                this.labelTulip.setVisible(true);
            }else{
                if(!(subTotalArray[0]>0)){
                    subTotalArray[0]=0;
                    this.labelTulip.setVisible(false);
                }
            }
            if (p.getNameProduct()=="Girasol"){
                double partialTotal = p.getPrice() * p.getQuantity();
                subTotalArray[1] = partialTotal;
                this.labelSunflower.setText("Compro los siguientes Girasoles: " + p.getQuantity() + " Y el precio es:           " + partialTotal);
                this.labelSunflower.setVisible(true);
            }else{
                if(!(subTotalArray[1]>0)){
                    subTotalArray[1]=0;
                    this.labelSunflower.setVisible(false);
                }
            }
            if (p.getNameProduct()=="Rosas"){
                double partialTotal = p.getPrice() * p.getQuantity();
                subTotalArray[2] = partialTotal;
                this.labelRoses.setText("Compro las siguientes Rosas: "+ p.getQuantity() + " Y el precio es:                " + partialTotal);
                this.labelRoses.setVisible(true);

            }else{
                if(!(subTotalArray[2]>0)){
                    subTotalArray[2]=0;
                    this.labelRoses.setVisible(false);
                }
            }
            if (p.getNameProduct()=="Claveles"){
                double partialTotal = p.getPrice() * p.getQuantity();
                subTotalArray[3] = partialTotal;
                this.labelCarnations.setText("Compro los siguientes Claveles: "+ p.getQuantity() + " Y el precio es:            " + partialTotal);
                this.labelCarnations.setVisible(true);

            }else{
                if(!(subTotalArray[3]>0)){
                    subTotalArray[3]=0;
                    this.labelCarnations.setVisible(false);
                }
            }
            if (p.getNameProduct()=="Camalotes"){
                double partialTotal = p.getPrice() * p.getQuantity();
                subTotalArray[4] = partialTotal;
                this.labelCamalote.setText("Compro los siguientes Camalotes: "+ p.getQuantity() + " Y el precio es:         " + partialTotal);
                this.labelCamalote.setVisible(true);

            }else{
                if(!(subTotalArray[4]>0)){
                    subTotalArray[4]=0;
                    this.labelCamalote.setVisible(false);
                }
            }
        }

        this.zoneString = new JLabel();


        for (double element : subTotalArray) {
            subTotal += element;
        }

        total = subTotal - ((subTotal*((zone.equals("Zona norte"))?Values.discount[0]:Values.discount[1]))/100);

        discountDouble = subTotal - total;


        this.labelSubTotal.setText("El subtotal de la compra sin descuento                              " + decimalFormat.format(subTotal));
        this.labelSubTotal.setPreferredSize(new Dimension(550, 40));
        this.labelSubTotal.setFont((new Font("Arial", 0, 18)));

        this.doubleDiscount.setText("El descuento obtenido fue de                                              -"+ decimalFormat.format(discountDouble));
        this.doubleDiscount.setPreferredSize(new Dimension(550, 40));
        this.doubleDiscount.setFont((new Font("Arial", 0, 18)));

        this.labelTotal.setText("El total a pagar es de                                                          "+ decimalFormat.format(total));
        this.labelTotal.setPreferredSize(new Dimension(550, 40));
        this.labelTotal.setFont((new Font("Arial", 0, 18)));


    }

    private URL getUrlImagen(String nombreIcono) {
        URL uri = getClass().getResource("/org/example/resources/"+nombreIcono);
        if(uri  == null) {
            System.out.println("Uri inexistente.*********");
            throw new RuntimeException("Error con recursos para imagenes");
        }
        return uri;
    }

}
