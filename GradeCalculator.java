/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Command Line Grade Calculator
 * Due: 02/03/2026
 * Platform/compiler: macOS/ Java JDK 17
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Derrick Patterson
*/

import java.io.*;
import java.util.Scanner;

public class GradeCalculator {
    // Default configuration constants
    private static final String DEFAULT_COURSE_NAME = "CMSC203 Computer Science I";
    private static final int DEFAULT_NUM_CATEGORIES = 3;
    private static final String DEFAULT_CATEGORY1_NAME = "Projects";
    private static final int DEFAULT_CATEGORY1_WEIGHT = 40;
    private static final String DEFAULT_CATEGORY2_NAME = "Quizzes";
    private static final int DEFAULT_CATEGORY2_WEIGHT = 30;
    private static final String DEFAULT_CATEGORY3_NAME = "Exams";
    private static final int DEFAULT_CATEGORY3_WEIGHT = 30;
    private static final int MAX_CATEGORIES = 5;
    
    public static void main(String[] args) {
        // Declare variables
        String courseName;
        int numCategories;
        // Create categories to process data
        String cat1Name = "", cat2Name = "", cat3Name = "", cat4Name = "", cat5Name = "";
        int cat1Weight = 0, cat2Weight = 0, cat3Weight = 0, cat4Weight = 0, cat5Weight = 0;
        double cat1Avg = 0.0, cat2Avg = 0.0, cat3Avg = 0.0, cat4Avg = 0.0, cat5Avg = 0.0;
        String studentFirstName = null;
        String studentLastName = null;
        double overallNumericAverage = 0.0;
        String letterGrade;
        String inputFileName = "grades_input.txt";
        String outputFileName = "grades_report.txt";
        boolean usedDefaultConfig = false;
        boolean plusMinusGrading = false;
        
        // Check command-line arguments
        if (args.length == 0) {
            // Use default input and output file names
            inputFileName = "grades_input.txt";
            outputFileName = "grades_report.txt";
        } else if (args.length == 1) {
            // Set input file name to args[0]
            inputFileName = args[0];
            // Use default output file name
            outputFileName = "grades_report.txt";
        } else if (args.length >= 2) {
            // Set input file name to args[0]
            inputFileName = args[0];
            // Set output file name to args[1]
            outputFileName = args[1];
        }
        
        // Read configuration file "gradeconfig.txt"
        File configFile = new File("gradeconfig.txt");
        if (configFile.exists() && configFile.canRead()) {
            try {
                Scanner configScanner = new Scanner(configFile);
                
                // Read course name
                courseName = configScanner.nextLine();
                
                // Read number of graded categories
                numCategories = configScanner.nextInt();
                configScanner.nextLine(); // consume newline
                
                // Initialize total weight sum
                int totalWeightSum = 0;
                
                // For each category
                for (int i = 0; i < numCategories; i++) {
                    String line = configScanner.nextLine();
                    
                    // Find the space position
                    int spaceIndex = line.indexOf(" ");
                    String catName = line.substring(0, spaceIndex);
                    String weightStr = line.substring(spaceIndex + 1);
                    
                    if (i == 0) {
                        cat1Name = catName;
                        cat1Weight = Integer.parseInt(weightStr);
                        totalWeightSum += cat1Weight;
                    } else if (i == 1) {
                        cat2Name = catName;
                        cat2Weight = Integer.parseInt(weightStr);
                        totalWeightSum += cat2Weight;
                    } else if (i == 2) {
                        cat3Name = catName;
                        cat3Weight = Integer.parseInt(weightStr);
                        totalWeightSum += cat3Weight;
                    } else if (i == 3) {
                        cat4Name = catName;
                        cat4Weight = Integer.parseInt(weightStr);
                        totalWeightSum += cat4Weight;
                    } else if (i == 4) {
                        cat5Name = catName;
                        cat5Weight = Integer.parseInt(weightStr);
                        totalWeightSum += cat5Weight;
                    }
                }
                
                configScanner.close();
                
                // Check if total weight sum is not 100
                if (totalWeightSum != 100) {
                    System.out.println("Error: Category weights do not sum to 100. Using default configuration.");
                    cat1Name = DEFAULT_CATEGORY1_NAME;
                    cat1Weight = DEFAULT_CATEGORY1_WEIGHT;
                    cat2Name = DEFAULT_CATEGORY2_NAME;
                    cat2Weight = DEFAULT_CATEGORY2_WEIGHT;
                    cat3Name = DEFAULT_CATEGORY3_NAME;
                    cat3Weight = DEFAULT_CATEGORY3_WEIGHT;
                    courseName = DEFAULT_COURSE_NAME;
                    numCategories = DEFAULT_NUM_CATEGORIES;
                    usedDefaultConfig = true;
                } else {
                    System.out.println("Configuration loaded successfully.");
                }
            } catch (Exception e) {
                System.out.println("Configuration file missing or invalid. Using default configuration.");
                cat1Name = DEFAULT_CATEGORY1_NAME;
                cat1Weight = DEFAULT_CATEGORY1_WEIGHT;
                cat2Name = DEFAULT_CATEGORY2_NAME;
                cat2Weight = DEFAULT_CATEGORY2_WEIGHT;
                cat3Name = DEFAULT_CATEGORY3_NAME;
                cat3Weight = DEFAULT_CATEGORY3_WEIGHT;
                courseName = DEFAULT_COURSE_NAME;
                numCategories = DEFAULT_NUM_CATEGORIES;
                usedDefaultConfig = true;
            }
        } else {
            System.out.println("Configuration file missing or invalid. Using default configuration.");
            cat1Name = DEFAULT_CATEGORY1_NAME;
            cat1Weight = DEFAULT_CATEGORY1_WEIGHT;
            cat2Name = DEFAULT_CATEGORY2_NAME;
            cat2Weight = DEFAULT_CATEGORY2_WEIGHT;
            cat3Name = DEFAULT_CATEGORY3_NAME;
            cat3Weight = DEFAULT_CATEGORY3_WEIGHT;
            courseName = DEFAULT_COURSE_NAME;
            numCategories = DEFAULT_NUM_CATEGORIES;
            usedDefaultConfig = true;
        }
        
        // Read student scores from input file
        File inputFile = new File(inputFileName);
        if (!inputFile.exists() || !inputFile.canRead()) {
            System.out.println("Error: Input file '" + inputFileName + "' is missing or unreadable.");
            System.exit(1);
        }
        
        try {
            Scanner inputScanner = new Scanner(inputFile);
            
            // Read student first name
            studentFirstName = inputScanner.next();
            
            // Read student last name
            studentLastName = inputScanner.next();
            if (inputScanner.hasNextLine()) {
                inputScanner.nextLine(); // consume newline
            }
            
            // Initialize overall weighted sum
            double overallWeightedSum = 0.0;
            
            // For each category
            for (int i = 0; i < numCategories; i++) {
                // Read category name from file
                String fileCategoryName = inputScanner.nextLine();
                
                // Get the expected category name based on index
                String expectedCategoryName = "";
                if (i == 0) {
                    expectedCategoryName = cat1Name;
                } else if (i == 1) {
                    expectedCategoryName = cat2Name;
                } else if (i == 2) {
                    expectedCategoryName = cat3Name;
                } else if (i == 3) {
                    expectedCategoryName = cat4Name;
                } else if (i == 4) {
                    expectedCategoryName = cat5Name;
                }
                
                // Check if category name matches
                if (!fileCategoryName.equals(expectedCategoryName)) {
                    System.out.println("Error: Invalid category name '" + fileCategoryName + "'. Expected '" + expectedCategoryName + "'.");
                    continue;
                }
                
                // Read number of scores for this category
                int numScores = inputScanner.nextInt();
                
                // Initialize category sum
                double categorySum = 0.0;
                
                // For each score
                for (int j = 0; j < numScores; j++) {
                    double score = inputScanner.nextDouble();
                    categorySum += score;
                }
                if (inputScanner.hasNextLine()) {
                    inputScanner.nextLine(); // consume newline
                }
                
                // Calculate category average
                double categoryAverage = categorySum / numScores;
                
                // Store average in appropriate variable and calculate weighted contribution
                if (i == 0) {
                    cat1Avg = categoryAverage;
                    overallWeightedSum += categoryAverage * (cat1Weight / 100.0);
                } else if (i == 1) {
                    cat2Avg = categoryAverage;
                    overallWeightedSum += categoryAverage * (cat2Weight / 100.0);
                } else if (i == 2) {
                    cat3Avg = categoryAverage;
                    overallWeightedSum += categoryAverage * (cat3Weight / 100.0);
                } else if (i == 3) {
                    cat4Avg = categoryAverage;
                    overallWeightedSum += categoryAverage * (cat4Weight / 100.0);
                } else if (i == 4) {
                    cat5Avg = categoryAverage;
                    overallWeightedSum += categoryAverage * (cat5Weight / 100.0);
                }
            }
            
            inputScanner.close();
            
            // Set overall numeric average
            overallNumericAverage = overallWeightedSum;
            
        } catch (Exception e) {
            System.out.println("Error reading input file: " + e.getMessage());
            System.exit(1);
        }
        
        // Prompt user via keyboard
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Apply +/- grading? (Y/N): ");
        String response = keyboard.next();
        
        // Loop while response is not valid
        while (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N")) {
            System.out.print("Invalid input. Please enter Y or N: ");
            response = keyboard.next();
        }
        
        // If response is Y or y
        if (response.equalsIgnoreCase("Y")) {
            plusMinusGrading = true;
        }
        
        // Determine base letter grade
        if (overallNumericAverage >= 90) {
            letterGrade = "A";
        } else if (overallNumericAverage >= 80) {
            letterGrade = "B";
        } else if (overallNumericAverage >= 70) {
            letterGrade = "C";
        } else if (overallNumericAverage >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
        
        // If plus/minus grading is enabled
        if (plusMinusGrading && !letterGrade.equals("F")) {
            // Get ones place digit of average
            int onesDigit = ((int) overallNumericAverage) % 10;
            
            if (onesDigit >= 7) {
                letterGrade += "+";
            } else if (onesDigit <= 2) {
                letterGrade += "-";
            }
        }

        // Write summary to output file
        try {
            PrintWriter writer = new PrintWriter(outputFileName);
            
            writer.println("========================================");
            writer.println("   CMSC203 Project 1 - Grade Calculator");
            writer.println("========================================");
            writer.println(); 
            if (!usedDefaultConfig) {
                writer.println("Configuration loaded successfully.");
            } else {
                writer.println("Configuration file missing or invalid. Using default configuration.");
            }
            writer.println(); 
            writer.println("Using input file: " + inputFileName);
            writer.println("Using output file: " + outputFileName);
            writer.println(); 
            writer.println("Reading student scores...");
            writer.println(); 
            writer.println("Student: " + studentFirstName + " " + studentLastName);
            writer.println("Course: " + courseName);
            writer.println(); 
            writer.println("Category Results:");
            for (int i = 0; i < numCategories; i++) {
                String catName = "";
                int catWeight = 0;
                double catAvg = 0.0;
                
                if (i == 0) {
                    catName = cat1Name;
                    catWeight = cat1Weight;
                    catAvg = cat1Avg;
                } else if (i == 1) {
                    catName = cat2Name;
                    catWeight = cat2Weight;
                    catAvg = cat2Avg;
                } else if (i == 2) {
                    catName = cat3Name;
                    catWeight = cat3Weight;
                    catAvg = cat3Avg;
                } else if (i == 3) {
                    catName = cat4Name;
                    catWeight = cat4Weight;
                    catAvg = cat4Avg;
                } else if (i == 4) {
                    catName = cat5Name;
                    catWeight = cat5Weight;
                    catAvg = cat5Avg;
                }
                
                writer.printf("  %s (%d%%): average = %.2f\n", catName, catWeight, catAvg);
            }
            writer.println(); 
            writer.println("Apply +/- grading? (Y/N): " + response);
            writer.println(); 
            writer.printf("Overall numeric average: %.2f\n", overallNumericAverage);
            writer.println("Base letter grade: " + letterGrade.charAt(0));
            writer.println("Final letter grade: " + letterGrade);
            
            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing to output file: " + e.getMessage());
        }
        
        // Display summary to console
        System.out.println();
        System.out.println("========================================");
        System.out.println("   CMSC203 Project 1 - Grade Calculator");
        System.out.println("========================================");
        System.out.println();
        if (!usedDefaultConfig) {
            System.out.println("Configuration loaded successfully.");
        } else {
            System.out.println("Configuration file missing or invalid. Using default configuration.");
        }
        System.out.println();
        System.out.println("Using input file: " + inputFileName);
        System.out.println("Using output file: " + outputFileName);
        System.out.println();
        System.out.println("Reading student scores...");
        System.out.println();
        System.out.println("Student: " + studentFirstName + " " + studentLastName);
        System.out.println("Course: " + courseName);
        System.out.println();
        System.out.println("Category Results:");
        for (int i = 0; i < numCategories; i++) {
            String catName = "";
            int catWeight = 0;
            double catAvg = 0.0;
            
            if (i == 0) {
                catName = cat1Name;
                catWeight = cat1Weight;
                catAvg = cat1Avg;
            } else if (i == 1) {
                catName = cat2Name;
                catWeight = cat2Weight;
                catAvg = cat2Avg;
            } else if (i == 2) {
                catName = cat3Name;
                catWeight = cat3Weight;
                catAvg = cat3Avg;
            } else if (i == 3) {
                catName = cat4Name;
                catWeight = cat4Weight;
                catAvg = cat4Avg;
            } else if (i == 4) {
                catName = cat5Name;
                catWeight = cat5Weight;
                catAvg = cat5Avg;
            }
            
            System.out.printf("  %s (%d%%): average = %.2f\n", catName, catWeight, catAvg);
        }
        System.out.println();
        System.out.println("Apply +/- grading? (Y/N): " + response);
        System.out.println();
        System.out.printf("Overall numeric average: %.2f\n", overallNumericAverage);
        System.out.println("Base letter grade: " + letterGrade.charAt(0));
        System.out.println("Final letter grade: " + letterGrade);
        System.out.println();
        System.out.println("Summary written to " + outputFileName);
        System.out.println("Program complete. Goodbye!");
        System.out.println();
        System.out.println("Programmer: Derrick Patterson");

        keyboard.close();
    }

}