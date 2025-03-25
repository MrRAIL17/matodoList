import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Définition des statuts possibles des tâches
enum Status {
    PENDING, ONGOING, DONE;
}

// Classe représentant une tâche
class Task {
    private String title;
    private String description;
    private Status status;
    private LocalDate createdDate;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = Status.PENDING; // Statut par défaut
        this.createdDate = LocalDate.now(); // Date de création
    }

    // Getters et Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    // Affichage des détails de la tâche
    public void displayTask() {
        System.out.println("Titre       : " + title);
        System.out.println("Description : " + description);
        System.out.println("Statut      : " + status);
        System.out.println("Créée le    : " + createdDate);
        System.out.println("-------------------------");
    }
}

// Classe gérant la To-Do List
class ToDoList {
    private List<Task> tasks = new ArrayList<>();

    // Ajouter une tâche
    public void addTask(String title, String description) {
        tasks.add(new Task(title, description));
        System.out.println("✅ Tâche ajoutée avec succès !");
    }

    // Modifier une tâche (titre, description, statut)
    public void modifyTask(int index, String newTitle, String newDescription, Status newStatus) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setTitle(newTitle);
            task.setDescription(newDescription);
            task.setStatus(newStatus);
            System.out.println("✅ Tâche modifiée avec succès !");
        } else {
            System.out.println("❌ Erreur : Numéro de tâche invalide !");
        }
    }

    // Supprimer une tâche
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("✅ Tâche supprimée !");
        } else {
            System.out.println("❌ Erreur : Numéro de tâche invalide !");
        }
    }

    // Afficher toutes les tâches
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("📭 Aucune tâche enregistrée.");
        } else {
            System.out.println("\n📌 --- Liste des Tâches ---");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("🔹 Tâche " + (i + 1) + ":");
                tasks.get(i).displayTask();
            }
        }
    }
}


// Classe principale contenant la méthode main()
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();

        while (true) {
            System.out.println("\n📋 MENU PRINCIPAL");
            System.out.println("1️⃣ Ajouter une tâche");
            System.out.println("2️⃣ Modifier une tâche");
            System.out.println("3️⃣ Supprimer une tâche");
            System.out.println("4️⃣ Afficher les tâches");
            System.out.println("5️⃣ Quitter");
            System.out.print("👉 Choisissez une option : ");
            
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            switch (choix) {
                case 1:
                    System.out.print("📌 Titre de la tâche : ");
                    String title = scanner.nextLine();
                    System.out.print("📝 Description : ");
                    String description = scanner.nextLine();
                    toDoList.addTask(title, description);
                    break;
                
                case 2:
                    toDoList.displayTasks();
                    System.out.print("🔄 Numéro de la tâche à modifier : ");
                    int indexModif = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consommer la ligne restante
                    
                    System.out.print("📌 Nouveau titre : ");
                    String newTitle = scanner.nextLine();
                    System.out.print("📝 Nouvelle description : ");
                    String newDescription = scanner.nextLine();
                    System.out.print("⚙️ Nouveau statut (PENDING, ONGOING, DONE) : ");
                    Status newStatus = Status.valueOf(scanner.nextLine().toUpperCase());

                    toDoList.modifyTask(indexModif, newTitle, newDescription, newStatus);
                    break;

                case 3:
                    toDoList.displayTasks();
                    System.out.print("🗑 Numéro de la tâche à supprimer : ");
                    int indexSupp = scanner.nextInt() - 1;
                    toDoList.removeTask(indexSupp);
                    break;

                case 4:
                    toDoList.displayTasks();
                    break;

                case 5:
                    System.out.println("👋 Programme terminé.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Choix invalide !");
            }
        }
    }
}