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
Цикломатската комплексност на овој код е 9, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли содржани во CFG.Во случајoв P=8, па цикломатската комплексност изнесува 9.
<br/>
Исто така со формулата E-N+2 каде E - бројот на ребри , N - бројот на јазли , во случајов Е - 26, N - 19, па цикломатската комплексност изенсува: 26-19+2 = 9.
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

        //A,B - C ; C - D,E ; D,E - F ; F - G ; G - H(i=0) ; H(i=0) - H(i<p.l()) ; H(i<p.l()) I ; I - K ; K - M ; M - H(i++) ; H(i++) - H(i<p.l()) ; H(i<p.l()) - O ; O - Q
        assertEquals(false, obj.function(new User("labinot", "labinotttt", "labi.aziri1@gmail.com"), addUserToList("1abinot", "labinotttt", "labi.aziri1@gmail.com")));

        //A,B - C ; C - D,E ; D,E - F ; F - G ; G - H(i=0) ; H(i=0) - H(i<p.l()) ; H(i<p.l()) - I ; I - J ; J - K; K - L ; L-M ; M - N ; N - H(i++) ; H(i++) - H(i<p.l()) ; H(i<p.l()) - O ; O - P
        assertEquals(true, obj.function(new User("labinot", "Labi.1234", "labi.aziri1@gmail.com"), addUserToList("labinot", "Labinot.1234", "labi.aziri1@gmail.com")));
    }
```
### Тест случаи според критериумот Multiple Condition
```java
    @Test
    void multipleConditionsTest() {

        //user.getUsername()!=null && user.getPassword()!=null

        //T T
        assertEquals(true, obj.function(new User("labinot","Labi.1234","labi.aziri1@gmail.com"),addUserToList("labinot","labinot","labi.aziri1@gmail.com")));
        //T F
        assertEquals(false, obj.function(new User("labinot", null , "labi.aziri1@gmail.com"), addUserToList("labinot", null , "labi.aziri1@gmail.com")));
        //F X
        assertEquals(false,obj.function(new User(null,"labi.123","labi.aziri1@gmail.com"),addUserToList(null ,"labi.123","labi.aziri1@gmail.com")));



        //!passwordLower.contains(user.getUsername().toLowerCase()) && password.length()>=8

        //T T
        assertEquals(true, obj.function(new User("labinot","Labi_123","labi.aziri1@gmail.com"),addUserToList("labinot","Labi_1234","labi.aziri1@gmail.com")));
        //T F
        assertEquals(false, obj.function(new User("labinot","Labi123","labi.aziri1@gmail.com"),addUserToList("labinot","Labi_123","labi.aziri1@gmail.com")));
        //F X
        assertEquals(false, obj.function(new User("labinot", "labinot", "labi.aziri1@gmail.com"), addUserToList("labinot", "labinot", "labi.aziri1@gmail.com")));


        //digit && upper && special

        //T T T
        assertEquals(true, obj.function(new User("labinot", "Labi_1234", "labi.aziri1@gmail.com"), addUserToList("labinot", "Labi_1234", "labi.aziri1@gmail.com")));
        //T T F
        assertEquals(false, obj.function(new User("labinot", "Labi1234", "labi.aziri1@gmail.com"), addUserToList("labinot", "Labi1234", "labi.aziri1@gmail.com")));
        //T F X
        assertEquals(false, obj.function(new User("labinot", "labi_1234", "labi.aziri1@gmail.com"), addUserToList("labinot", "labi_1234", "labi.aziri1@gmail.com")));
        //F X X
        assertEquals(false, obj.function(new User("labinot", "labinot_", "labi.aziri1@gmail.com"), addUserToList("labinot", "labinot_", "labi.aziri1@gmail.com")));
    }
```

### Објаснување на напишаните unit tests

## Every Branch Documentation

| Test Case         | (user=null, allUsers=null) | (user="labinot", null, "labi.aziri1@gmail.com", allUsers="labinot", null, "labi.aziri1@gmail.com") | (user="labinot", "labinot", "labi.aziri1@gmail.com", allUsers="labinot", "labinot", "labi.aziri1@gmail.com") | (user="labinot", "labinotttt", "labi.aziri1@gmail.com", allUsers="labinot", "labinotttt", "labi.aziri1@gmail.com") | (user="labinot", "Labi.1234", "labi.aziri1@gmail.com", allUsers="labinot", "Labi.1234", "labi.aziri1@gmail.com") |
| ----------------- | :------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
| A,B-Q             |             *              |                                                              |                                                              |                                                              |                                                              |
| A,B-C             |                            |                              *                               |                              *                               |                              *                               |                              *                               |
| C-Q               |                            |                              *                               |                                                              |                                                              |                                                              |
| C-D,E             |                            |                                                              |                              *                               |                              *                               |                              *                               |
| D,E-F             |                            |                                                              |                              *                               |                              *                               |                              *                               |
| F-Q               |                            |                                                              |                              *                               |                                                              |                                                              |
| F-G               |                            |                                                              |                                                              |                              *                               |                              *                               |
| G-H(i=0)          |                            |                                                              |                                                              |                              *                               |                              *                               |
| H(i=0)-H(i<p.l()) |                            |                                                              |                                                              |                              *                               |                              *                               |
| H(i<p.l())-I      |                            |                                                              |                                                              |                              *                               |                              *                               |
| I-J               |                            |                                                              |                                                              |                                                              |                              *                               |
| J-K               |                            |                                                              |                                                              |                                                              |                              *                               |
| I-K               |                            |                                                              |                                                              |                              *                               |                                                              |
| K-L               |                            |                                                              |                                                              |                                                              |                              *                               |
| L-M               |                            |                                                              |                                                              |                                                              |                              *                               |
| K-M               |                            |                                                              |                                                              |                              *                               |                                                              |
| M-N               |                            |                                                              |                                                              |                                                              |                              *                               |
| M-H(i++)          |                            |                                                              |                                                              |                              *                               |                                                              |
| N-H(i++)          |                            |                                                              |                                                              |                                                              |                              *                               |
| H(i++)-H(i<p.l()) |                            |                                                              |                                                              |                              *                               |                              *                               |
| H(i<p.l())-O      |                            |                                                              |                                                              |                              *                               |                              *                               |
| O-Q               |                            |                                                              |                                                              |                              *                               |                                                              |
| O-P               |                            |                                                              |                                                              |                                                              |                              *                               |

<br/>
<br/>

## Multiple Condition Documentation

> user.getUsername()!=null && user.getPassword()!=null 

| Combination | Possible Test Case                        | Branch  |
| :---------: | :---------------------------------------- | :-----: |
|     T T     | username="labinot" , password="Labi.1234" | C - D,E |
|     T F     | username="labinot" , password=null        |  C - Q  |
|     F X     | username=null , password="labi123"        |  C - Q  |

<br/>

> passwordLower.contains(user.getUsername().toLowerCase()) && password.length()>=8

| Combination | Possible Test Case                       | Branch |
| :---------: | ---------------------------------------- | :----: |
|     T T     | username="labinot" , password="Labi_123" | F - G  |
|     T F     | username="labinot" , password="Labi123"  | F - Q  |
|     F X     | username="labinot" , password="labinot"  | F - Q  |

<br/>

> digit && upper && special

| Combination | Possible Test Case   | Branch |
| :---------: | -------------------- | :----: |
|    T T T    | password="Labi_1234" | O - P  |
|    T T F    | password="Labi1234"  | O - Q  |
|    T F X    | password="labi_1234" | O - Q  |
|    F X X    | password="labinot_"  | O - Q  |