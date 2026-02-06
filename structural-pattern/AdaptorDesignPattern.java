interface IReports {
    public abstract String getJsonData();
}

class main {
    public static void main(String[] args) {
        IReports adapter = new JsonXmlAdaptor();
        Client client = new Client(adapter);
        System.out.println(client.provideData());
    }
}

//client
class Client {
    IReports reports;

    public Client(IReports reports) {
        this.reports = reports;
    }
    public String provideData(){
        return reports.getJsonData();
    }
}


//3rd party libraryr adaptee
class DataProvidor{
    public String XMLProvidor () {
        return "<DATA>Value<DATA>";
    }
}


//adaptor
class JsonXmlAdaptor implements  IReports{
    DataProvidor dataProvidor;

    public JsonXmlAdaptor(){
        dataProvidor = new DataProvidor();
    }

    public String getJsonData(){
        dataProvidor.XMLProvidor();
        return "{ \"DATA\": \"Value\" }";
    }
}

