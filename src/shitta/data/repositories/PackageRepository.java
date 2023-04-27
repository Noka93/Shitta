package shitta.data.repositories;

import java.util.List;

import shitta.data.model.Package;

public interface PackageRepository {

    Package save(Package aPackage);

    void delete(Package aPackage);

    void delete(int id);

    List<Package> findAll();

    Package findById(int id);

    long count();
}
