package mapper;

import entity.Class;

public interface ClassMapper {
 void addClass(Class c);
 Class getClaById(String id);
 void delClaById(String id);
 void updateClaById(Class cla);
}
