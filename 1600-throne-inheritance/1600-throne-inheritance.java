class ThroneInheritance {
    private Person king;
    private Map<String, Person> persons;

    public ThroneInheritance(String kingName) {
        king = new Person(kingName);
        persons = new HashMap<>();
        persons.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Person parent = persons.get(parentName);
        Person newChild = new Person(childName);
        parent.getChildren().add(newChild);
        persons.put(childName, newChild);
    }

    public void death(String name) {
        Person person = persons.get(name);
        person.setIsAlive(false);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new LinkedList<>();
        dfs(order, king);
        return order;
    }

    private void dfs(List<String> order, Person person) {
        if (person.getIsAlive())
            order.add(person.getName());

        for (Person child : person.getChildren())
            dfs(order, child);
    }
}

class Person {
    private String name;
    private List<Person> children;
    private boolean isAlive;

    public Person(String name) {
        this.name = name;
        children = new LinkedList<>();
        isAlive = true;
    }

    public String getName() {
        return this.name;
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }

    public void setIsAlive(boolean flag) {
        this.isAlive = flag;
    }
}