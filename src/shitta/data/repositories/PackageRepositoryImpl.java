package shitta.data.repositories;

import java.util.ArrayList;
import java.util.List;

import shitta.data.model.Package;


public class PackageRepositoryImpl implements PackageRepository {

    private int lastIdCreated;

    private List<Package> packages = new ArrayList<>();
    @Override
    public Package save(Package aPackage) {
        boolean isSaved = aPackage.getId()!= 0;
        if (isSaved) update(aPackage);else saveNewPackage(aPackage);

        return aPackage;
    }

    private void update(Package aPackage){
//        Package savedPackage = findById(aPackage.getId());
//        int indexOfSavedPackage = packages.indexOf(savedPackage);
//        packages.set(indexOfSavedPackage, aPackage);
        Package savedPackage = findById(aPackage.getId());
        packages.remove(savedPackage);
        packages.add(aPackage);
    }

    private void saveNewPackage(Package aPackage){
        aPackage.setId(generateId());
        packages.add(aPackage);
        lastIdCreated++;
    }

    private int generateId() {
        return lastIdCreated +1;
    }

    @Override
    public void delete(Package aPackage) {
        packages.remove(aPackage.getId());
        packages.add(aPackage);
//        lastIdCreated--;
    }
    @Override
    public void delete(int id) {
        Package foundPackage = findById(id);
        delete(foundPackage);
    }

    @Override
    public List<Package> findAll() {
        return packages;
    }

    @Override
    public Package findById(int id) {
        for (Package aPackage: packages){
            if (aPackage.getId() == id){
                return aPackage;
            }
        }
        return null;
    }
    @Override
    public long count() {
        return packages.size();
    }
}
