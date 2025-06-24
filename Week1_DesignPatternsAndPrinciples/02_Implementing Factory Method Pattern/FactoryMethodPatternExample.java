interface Doc {
    void show();
}
class WordFile implements Doc {
    public void show() {
        System.out.println("This is a Word document.");
    }
}
class PdfFile implements Doc {
    public void show() {
        System.out.println("This is a PDF document.");
    }
}
class ExcelFile implements Doc {
    public void show() {
        System.out.println("This is an Excel document.");
    }
}
abstract class DocFactory {
    abstract Doc createDoc();
}
class WordFactory extends DocFactory {
    public Doc createDoc() {
        return new WordFile();
    }
}

class PdfFactory extends DocFactory {
    public Doc createDoc() {
        return new PdfFile();
    }
}
class ExcelFactory extends DocFactory {
    public Doc createDoc() {
        return new ExcelFile();
    }
}


public class FactoryMethodPatternExample {
    public static void main(String[] args) {
    
        DocFactory wf = new WordFactory();
        Doc word = wf.createDoc();
        word.show();
        DocFactory pf = new PdfFactory();
        Doc pdf = pf.createDoc();
        pdf.show();

        DocFactory ef = new ExcelFactory();
        Doc excel = ef.createDoc();
        excel.show();
    }
}