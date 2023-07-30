package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Bu anotasyon, bir sınıfın bir hizmet sınıfı olduğunu belirtir. Hizmet sınıfları, uygulamanızın gerçek iş mantığını içeren sınıflardır.
@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    //@Autowired: Bu anotasyon, bir nesnenin otomatik olarak oluşturulmasını ve enjekte edilmesini sağlar.
    //Örnek olarak, bir Service sınıfının bir Repository sınıfına ihtiyacı varsa,
    // Service sınıfında @Autowired kullanarak Repository sınıfının nesnesinin otomatik olarak oluşturulmasını ve enjekte edilmesini sağlayabilirsiniz.
    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return this.productDao.findAll();
    }
}
