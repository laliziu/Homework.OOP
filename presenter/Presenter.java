package presenter;

import model.Service;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        service = new Service();
        this.view = view;
    }
    public Service getService() {
        return service;
    }
    public void setService(Service service) {
        this.service = service;
    }

    public void addHuman(String name, String gender, String birthDate, long idFather, long idMother) {
        String answer = service.addHuman(name, gender, birthDate, idFather, idMother);
        view.print(answer);
    }

    public void getHumanList() {
        String answer = service.getHumanList();
        view.print(answer);
    }
    public Boolean isTreeEmpty() {
        return service.isTreeEmpty();
    }
    public int getTreeSize() {
        return service.getTreeSize();
    }
    public Boolean isContainsItem(String fullName) {
        return service.isContainsItem(fullName);
    }
    public void sortByName() {
        view.print(service.sortByName());
    }
    public void sortByAge() {
        view.print(service.sortByAge());
    }

    public void sortByDateBirth() {
        view.print(service.sortByDateBirth());
    }
    public Boolean delFromTree(String fullName) {
        return service.delFromTree(fullName);
    }
    public Boolean setDateBirth(String itemIndex, int birthY, int birthM,  int birthD) {
        return service.setDateBirth(itemIndex, birthY, birthM, birthD);
    }

    public Boolean setDateEndlife(String itemIndex, int EndlifeY, int EndlifeM,  int EndlifeD) {
        return service.setDateEndlife(itemIndex, EndlifeY, EndlifeM, EndlifeD);
    }
    public Boolean setMother(String itemIndex, String motherName) {
        return service.setMother(itemIndex, motherName);
    }

    public Boolean setFather(String itemIndex, String fatherName) {
        return service.setFather(itemIndex, fatherName);
    }

    public Boolean setChild(String itemIndex, String childName) {
        return service.setChild(itemIndex, childName);
    }
    public Boolean saveTree(String option){
        return service.saveTree(option);
    }

    public Boolean loadTree(String filename) {
        return service.loadTree(filename);
    }
    public void exit() {
        view.print("Всего доброго!");
        service.exit();
    }
    public void sortByDateBirthReverse() {
        view.print(service.sortByDateBirthReverse());
    }

    public void getInfo() {
        view.print(service.getInfo());
    }


        public Boolean addHumanToTree(String data) {
            return service.addHumanToTree(data);
        }

    public void getItem(String fullName) {
        String item = service.getItemByName(fullName);
        view.repeatLine();
        view.print(item);
        view.repeatLine();
    }
    public Boolean setFullname(String itemIndex, String fullName) {
        return service.setFullname(itemIndex, fullName);
    }
}
