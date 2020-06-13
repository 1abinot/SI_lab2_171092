# Втора лабораториска вежба по Софтверско инженерство

## Лабинот Азири, бр. на индекси 171092

### Група на код:
Ја добив групата на код 4
<br/>
### Control Flow Graph:
<!--- Images -->
![Control Flow Graph](/images/CFG.jpg)
<br/>
### Цикломатска комплексност
Цикломатската комплексност на овој код е 8, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли содржани во CFG.
<br/>
### Тест случаи според критериумот Every Branch
```java
	@Test
    void everyBranchTest() {
        //A,B - Q
        assertEquals(false, obj.function(null, addUserToList("null")));

        //A,B - C ; C - Q
        assertEquals(false, obj.function(new User("labinot", null, "labi.aziri1@gmail.com"), addUserToList("labinot", "null", "labi.aziri1@gmail.com")));

        //A,B - C ; C - D,E ; D,E - F ; F - Q
        assertEquals(false, obj.function(new User("labinot", "labinot", "labi.aziri1@gmail.com"), addUserToList("labinot", "labinot", "labi.aziri1@gmail.com")));

        //A,B - C ; C - D,E ; D,E - F ; F - G ; G - H ; H - I ; I - K ; K - M ; M - O ; O - Q
        assertEquals(false, obj.function(new User("labinot", "labinotttt", "labi.aziri1@gmail.com"), addUserToList("1abinot", "labinotttt", "labi.aziri1@gmail.com")));

        //A,B - C ; C - D,E ; D,E - F ; F - G ; G - H ; H - I ; I - J ; J - K ; K - L ; L - M ; M - N ; N - O ; O - P
        assertEquals(true, obj.function(new User("labinot", "Labi.1234", "labi.aziri1@gmail.com"), addUserToList("labinot", "Labinot.123", "labi.aziri1@gmail.com")));
    }
```