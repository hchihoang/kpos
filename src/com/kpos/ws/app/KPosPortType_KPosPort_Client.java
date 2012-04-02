
package com.kpos.ws.app;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.2.8
 * Sun Apr 01 17:36:56 EDT 2012
 * Generated source version: 2.2.8
 * 
 */

public final class KPosPortType_KPosPort_Client {

    private static final QName SERVICE_NAME = new QName("http://ws.kpos.com/app", "KPosService");

    private KPosPortType_KPosPort_Client() {
    }

    public static void main(String args[]) throws Exception {
        URL wsdlURL = KPosService.WSDL_LOCATION;
        if (args.length > 0) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        KPosService ss = new KPosService(wsdlURL, SERVICE_NAME);
        KPosPortType port = ss.getKPosPort();  
        
        {
        System.out.println("Invoking listTables...");
        com.kpos.ws.app.ListTablesType _listTables_parameters = null;
        com.kpos.ws.app.ListTablesResponseType _listTables__return = port.listTables(_listTables_parameters);
        System.out.println("listTables.result=" + _listTables__return);


        }
        {
        System.out.println("Invoking saveTable...");
        com.kpos.ws.app.SaveTableType _saveTable_parameters = null;
        com.kpos.ws.app.SaveTableResponseType _saveTable__return = port.saveTable(_saveTable_parameters);
        System.out.println("saveTable.result=" + _saveTable__return);


        }
        {
        System.out.println("Invoking listPrinters...");
        com.kpos.ws.app.ListPrintersType _listPrinters_parameters = null;
        com.kpos.ws.app.ListPrintersResponseType _listPrinters__return = port.listPrinters(_listPrinters_parameters);
        System.out.println("listPrinters.result=" + _listPrinters__return);


        }
        {
        System.out.println("Invoking deleteTable...");
        com.kpos.ws.app.DeleteTableType _deleteTable_parameters = null;
        com.kpos.ws.app.DeleteTableResponseType _deleteTable__return = port.deleteTable(_deleteTable_parameters);
        System.out.println("deleteTable.result=" + _deleteTable__return);


        }
        {
        System.out.println("Invoking deleteCategory...");
        com.kpos.ws.app.DeleteCategoryType _deleteCategory_parameters = null;
        com.kpos.ws.app.DeleteCategoryResponseType _deleteCategory__return = port.deleteCategory(_deleteCategory_parameters);
        System.out.println("deleteCategory.result=" + _deleteCategory__return);


        }
        {
        System.out.println("Invoking updateSaleItemOption...");
        com.kpos.ws.app.UpdateSaleItemOptionType _updateSaleItemOption_parameters = null;
        com.kpos.ws.app.UpdateSaleItemOptionResponseType _updateSaleItemOption__return = port.updateSaleItemOption(_updateSaleItemOption_parameters);
        System.out.println("updateSaleItemOption.result=" + _updateSaleItemOption__return);


        }
        {
        System.out.println("Invoking deleteSaleItem...");
        com.kpos.ws.app.DeleteSaleItemType _deleteSaleItem_parameters = null;
        com.kpos.ws.app.DeleteSaleItemResponseType _deleteSaleItem__return = port.deleteSaleItem(_deleteSaleItem_parameters);
        System.out.println("deleteSaleItem.result=" + _deleteSaleItem__return);


        }
        {
        System.out.println("Invoking listCategory...");
        com.kpos.ws.app.ListCategoryType _listCategory_parameters = null;
        com.kpos.ws.app.ListCategoryResponseType _listCategory__return = port.listCategory(_listCategory_parameters);
        System.out.println("listCategory.result=" + _listCategory__return);


        }
        {
        System.out.println("Invoking createCategory...");
        com.kpos.ws.app.CreateCategoryType _createCategory_parameters = new com.kpos.ws.app.CreateCategoryType();
        com.kpos.ws.app.CreateCategoryResponseType _createCategory__return = port.createCategory(_createCategory_parameters);
        System.out.println("createCategory.result=" + _createCategory__return);


        }
        {
        System.out.println("Invoking deleteSaleItemOption...");
        com.kpos.ws.app.DeleteSaleItemOptionType _deleteSaleItemOption_parameters = null;
        com.kpos.ws.app.DeleteSaleItemOptionResponseType _deleteSaleItemOption__return = port.deleteSaleItemOption(_deleteSaleItemOption_parameters);
        System.out.println("deleteSaleItemOption.result=" + _deleteSaleItemOption__return);


        }
        {
        System.out.println("Invoking updateSaleItem...");
        com.kpos.ws.app.UpdateSaleItemType _updateSaleItem_parameters = null;
        com.kpos.ws.app.UpdateSaleItemResponseType _updateSaleItem__return = port.updateSaleItem(_updateSaleItem_parameters);
        System.out.println("updateSaleItem.result=" + _updateSaleItem__return);


        }
        {
        System.out.println("Invoking deletePrinter...");
        com.kpos.ws.app.DeletePrinterType _deletePrinter_parameters = null;
        com.kpos.ws.app.DeletePrinterResponseType _deletePrinter__return = port.deletePrinter(_deletePrinter_parameters);
        System.out.println("deletePrinter.result=" + _deletePrinter__return);


        }
        {
        System.out.println("Invoking createSaleItemOption...");
        com.kpos.ws.app.CreateSaleItemOptionType _createSaleItemOption_parameters = null;
        com.kpos.ws.app.CreateSaleItemOptionResponseType _createSaleItemOption__return = port.createSaleItemOption(_createSaleItemOption_parameters);
        System.out.println("createSaleItemOption.result=" + _createSaleItemOption__return);


        }
        {
        System.out.println("Invoking createPrinter...");
        com.kpos.ws.app.CreatePrinterType _createPrinter_parameters = null;
        com.kpos.ws.app.CreatePrinterResponseType _createPrinter__return = port.createPrinter(_createPrinter_parameters);
        System.out.println("createPrinter.result=" + _createPrinter__return);


        }
        {
        System.out.println("Invoking updatePrinter...");
        com.kpos.ws.app.UpdatePrinterType _updatePrinter_parameters = null;
        com.kpos.ws.app.UpdatePrinterResponseType _updatePrinter__return = port.updatePrinter(_updatePrinter_parameters);
        System.out.println("updatePrinter.result=" + _updatePrinter__return);


        }
        {
        System.out.println("Invoking fetchSaleItem...");
        com.kpos.ws.app.FetchSaleItemType _fetchSaleItem_parameters = null;
        com.kpos.ws.app.FetchSaleItemResponseType _fetchSaleItem__return = port.fetchSaleItem(_fetchSaleItem_parameters);
        System.out.println("fetchSaleItem.result=" + _fetchSaleItem__return);


        }
        {
        System.out.println("Invoking fetchTable...");
        com.kpos.ws.app.FetchTableType _fetchTable_parameters = null;
        com.kpos.ws.app.FetchTableResponseType _fetchTable__return = port.fetchTable(_fetchTable_parameters);
        System.out.println("fetchTable.result=" + _fetchTable__return);


        }
        {
        System.out.println("Invoking listSaleItemsForCategory...");
        com.kpos.ws.app.ListSaleItemsForCategoryType _listSaleItemsForCategory_parameters = null;
        com.kpos.ws.app.ListSaleItemsForCategoryResponseType _listSaleItemsForCategory__return = port.listSaleItemsForCategory(_listSaleItemsForCategory_parameters);
        System.out.println("listSaleItemsForCategory.result=" + _listSaleItemsForCategory__return);


        }
        {
        System.out.println("Invoking updateCategory...");
        com.kpos.ws.app.UpdateCategoryType _updateCategory_parameters = null;
        com.kpos.ws.app.UpdateCategoryResponseType _updateCategory__return = port.updateCategory(_updateCategory_parameters);
        System.out.println("updateCategory.result=" + _updateCategory__return);


        }
        {
        System.out.println("Invoking createSaleItem...");
        com.kpos.ws.app.CreateSaleItemType _createSaleItem_parameters = null;
        com.kpos.ws.app.CreateSaleItemResponseType _createSaleItem__return = port.createSaleItem(_createSaleItem_parameters);
        System.out.println("createSaleItem.result=" + _createSaleItem__return);


        }

        System.exit(0);
    }

}
