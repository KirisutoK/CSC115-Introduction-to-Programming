import java.util.Scanner;

public class About_Me {
    public static void main(String[] args) {
        Menu();
        about_me();
    }

    public static void Menu() { // This is the UI/Menu for users to select which number to choose specifically on what they want to know.
        System.out.println("\n+==========+-ABOUT-ME-+==========+");
        System.out.println("                                    ");
        System.out.println("1. Summary         7. Education     ");
        System.out.println("2. My Story        8. Expertise     ");
        System.out.println("3. My Ambition     9. Skills        ");
        System.out.println("4. Contacts        10. Links        ");
        System.out.println("5. Language        11. Hobbies      ");
        System.out.println("6. Experience      12. Connections  ");
        System.out.println("                                    ");
        System.out.println("+==-==-==-==-==-==-==-==-==-==-==+");
    }

    public static void about_me() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWhat do you want to know? (Pick a number from 1-12)");
        int AboutMe = scanner.nextInt();

        switch (AboutMe) {
            case 1:
                System.out.println("\n====================================Summary====================================");
                System.out.println("👨 Christ Aerjil C. Dampog | 19 | Pure Filipino | US Citizen");
                System.out.println("📍 Waterloo, NY 13165 | 🎓 Computer Information Systems");
                System.out.println("\n    I am a creative and solutions-driven FLCC Student with skills in digital design,");
                System.out.println("web development, video/photo editing and hardware/software troubleshooting. ");
                System.out.println("Experienced in customer service, eCommerce, and team collaboration. Bilingual, ");
                System.out.println("adaptable, and detail -oriented, with a strong drive to contribute technical ");
                System.out.println("expertise and creativity while continuing to grow professionally. to work under");
                System.out.println("\nMotivated and responsible with strong technical skills and a proven ability");
                System.out.println("pressure. Adaptable and organized, ready to contribute to team success while applying");
                System.out.println("education and enhancing organizational goals. Skilled in software applications,");
                System.out.println("problem-solving, and time management.");
                System.out.println("===============================================================================");
                break;

            case 2:
                System.out.println("\n====================================My-Story====================================");
                System.out.println("    I grew up in the Philippines, and during middle school, I was known as a creative,");
                System.out.println("smart, and cooperative student. I had many friends and was well-connected through");
                System.out.println("my family's social circle.");
                System.out.println(" ");
                System.out.println("When I was 8 years old, my mom moved to America and later remarried, starting a new");
                System.out.println("chapter with a blended family. Fast forward to high school, I consistently ranked at");
                System.out.println("the top of my class and often led group projects, earning a reputation as someone");
                System.out.println("reliable, quick-witted, calm under pressure, and capable of leadership. Eventually,");
                System.out.println("my mom called to let me know that I, along with my siblings, would be moving to America");
                System.out.println("to live with her.");
                System.out.println(" ");
                System.out.println("After arriving, I enrolled at Waterloo High School, where I continued to stay cooperative,");
                System.out.println("focused, and eager to learn. I made it a priority to adapt to the new environment and");
                System.out.println("culture, paying attention to the small details from communication styles to social");
                System.out.println("behavior so I could adjust, connect, and grow.");
                System.out.println(" ");
                System.out.println("After graduating from Waterloo High School with a 3.5 GPA, I was preparing to join the");
                System.out.println("U.S. Air Force. It had been a goal I held onto for a long time, but just before enlistment,");
                System.out.println("my medical records revealed that I had an allergic reaction to shellfish. Even though");
                System.out.println("I had no trouble eating it, I was still required to carry an EpiPen, and that small");
                System.out.println("detail was enough to close the door on my opportunity to serve.");
                System.out.println(" ");
                System.out.println("At first, it felt like the path I had worked hard for had suddenly disappeared. But");
                System.out.println("instead of letting that moment define me, I decided to move forward. I enrolled at Finger");
                System.out.println("Lakes Community College, determined to make the most of this new chapter. What began as");
                System.out.println("a disappointment turned into a blessing, I discovered new skills, gained knowledge");
                System.out.println("I never expected, and learned how to adapt in the face of setbacks. In the process, I grew");
                System.out.println("stronger, more disciplined, and more confident in carving my own path toward the future.");
                System.out.println("+================================================================================+");
                break;

            case 3:
                System.out.println("\n====================================My-Ambition====================================");
                System.out.println("    I aspire to build a successful career in IT and technology-driven fields, aiming to");
                System.out.println("earn a six-figure income while continuously developing my skills and creativity. I am");
                System.out.println("eager to collaborate with colleagues, connect with clients and staff, and contribute to");
                System.out.println("innovative projects.");
                System.out.println(" ");
                System.out.println("    My goal is to secure a stable position that allows me to grow professionally, to");
                System.out.println("emerging technologies, and stay ahead in the ever-evolving job market. With God guiding");
                System.out.println(" my path, I am committed to embracing challenges, seizing opportunities, and walking");
                System.out.println("the road to success with faith, resilience, and purpose.");
                System.out.println("===================================================================================");
                break;

            case 4:
                System.out.println("\n==================Contacts==================");
                System.out.println("📱 Phone Number: +1(680)-287-7958");
                System.out.println("📫 Gmail: KirisutoK@Gmail.com");
                System.out.println("📧 School Email: cdampog@fingerlakes.edu");
                System.out.println("📍 Waterloo, NY 13165");
                System.out.println("============================================");
                break;

            case 5:
                System.out.println("\n========Language========");
                System.out.println("Fluent English");
                System.out.println("Tagalog");
                System.out.println("Native Tagalog");
                System.out.println("========================");
                break;

            case 6:
                System.out.println("\n=====================================Experience=====================================");
                System.out.println("🏪 Bella Jewellers LLC | 📍 Waterloo, NY 13165");
                System.out.println("🧑 Retail Store Associate | 📅 June 2025 - Currently working");
                System.out.println("\n◆ Set up devices (Printers, PC, & Security Cameras) and provide troubleshooting.");
                System.out.println("◆ Maintaining cleanliness environment and product.");
                System.out.println("◆ Making a website using Wix and creating promotional videos.");
                System.out.println("◆ Sales management.");
                System.out.println("◆ Greetings and assisting customers in selecting jewelry and accessories based on");
                System.out.println("  personal style.");
                System.out.println("◆ Provided product knowledge to customers about gemstones, metals, and care");
                System.out.println("  techniques.");
                System.out.println("\n🏪 Loo Brew Internship | 📍 Waterloo, NY 13165");
                System.out.println("☕ Barista | 📅 Oct 2024 - June 2025");
                System.out.println("\n◆ Customer communication and informational assistance.");
                System.out.println("◆ Maintaining a clean environment.");
                System.out.println("◆ Prepared and served a variety of coffee beverages to customers.");
                System.out.println("◆ Maintained cleanliness and organization of the coffee bar and seating area.");
                System.out.println("◆ Assisted customers with menu selections and provided product recommendations.");
                System.out.println("◆ Handled cash transactions accurately at the point of sale system.");
                System.out.println("◆ Collaborated with team members to meet peak service demands efficiently.");
                System.out.println("◆ Engaged with customers to create a welcoming atmosphere in the café.");
                System.out.println("◆ Memorized recipes for specialty coffee beverages and seasonal offerings.");
                System.out.println("====================================================================================");
                break;

            case 7:
                System.out.println("\n=================Education=================");
                System.out.println("🏫 Finger Lakes Community College | 🎓 May 2027");
                System.out.println("💻 Major in Computer Information Systems");
                System.out.println("📅 Fall 2025 - Currently Enrolled");
                System.out.println(" ");
                System.out.println("🏫 Waterloo High School | 🎓 June 2025");
                System.out.println("💻 High School Diploma");
                System.out.println("📝 3.56 GPA ");
                System.out.println("📅 Oct 2024 - June 2025");
                System.out.println(" ");
                System.out.println("🏫 Iligan Medical Center College -Basic Education Department | 🎓 Oct 2024 (Transferred)");
                System.out.println("💻 Major in Technological Vocation Livelihood - Information Communication Technology");
                System.out.println("📝 Average Grade of 87");
                System.out.println("📅 June 2022 - Oct 2024");
                System.out.println("===========================================");
                break;

            case 8:
                System.out.println("\n======================Expertise======================");
                System.out.println("◆ Hardware/software cleaning, set up, and troubleshooting");
                System.out.println("◆ Team Leadership & Management");
                System.out.println("◆ Creative arts & drawings");
                System.out.println("◆ Customer service and team collaboration");
                System.out.println("=====================================================");
                break;

            case 9:
                System.out.println("\n================Skills================");
                System.out.println("◆ Video Editing & Photo Editing");
                System.out.println("◆ Graphic & Web Design");
                System.out.println("◆ Web Development (HTML, CSS, JavaScript)");
                System.out.println("◆ Ecommerce & Drop-shipping");
                System.out.println("◆ Product Merchandising and Marketing");
                System.out.println("◆ Basic programming (Java)");
                System.out.println("======================================");
                break;

            case 10:
                System.out.println("\n================================Links================================");
                System.out.println("-->General:");
                System.out.println("Linkedln: https://www.linkedin.com/in/christ-aerjil-dampog-246673345/");
                System.out.println("Handshake: https://flcc.joinhandshake.com/profiles/christaerjil_dampog");
                System.out.println("-->Coding:");
                System.out.println("Github: https://github.com/KirisutoK");
                System.out.println("Roblox Games: https://www.roblox.com/users/1094441872/favorites#!/places");
                System.out.println("-->Business:");
                System.out.println("Ebay: https://www.ebay.com/usr/aergilz");
                System.out.println("Etsy: https://www.etsy.com/shop/AergilzStore");
                System.out.println("Wix: https://www.bellajewellersllc.com/");
                System.out.println("-->Art:");
                System.out.println("Pinterest: https://ph.pinterest.com/kirisutoken/my-arts/");
                System.out.println("=====================================================================");
                break;

            case 11:
                System.out.println("\n=====================Hobbies=====================");
                System.out.println("◆ Sketching/Drawing          ◆ Reading Comics   ");
                System.out.println("◆ Coding/Developing          ◆ Watching Movies  ");
                System.out.println("◆ Video/Photo Editing        ◆ Anime            ");
                System.out.println("◆ Skateboarding              ◆ Socialization    ");
                System.out.println("◆ Biking                     ◆ Dancing          ");
                System.out.println("◆ Outdoor Activities         ◆ Swimming         ");
                System.out.println("◆ Likes fluffy animals       ◆ Music            ");
                System.out.println("=================================================");
                break;

            case 12:
                System.out.println("\n==============Connections==============");
                System.out.println("1. Family              5. Classmates   ");
                System.out.println("2. Best Friends        6. Co-Workers   ");
                System.out.println("3. Friends             7. Neighbor     ");
                System.out.println("4. Teacher/Professor   8. Crush        ");
                System.out.println("=======================================");

                System.out.println("\nChoose which connection? (Pick a number from 1-8)");
                int CASE12CHOICE = scanner.nextInt();

                switch(CASE12CHOICE) {
                    case 1:
                        System.out.println("\n====================Family====================");
                        System.out.println("◆ (Grandmother) Zelda Calapre Dampog ");
                        System.out.println("◆ (Grandfather) Jevier Calapre Dampog ");
                        System.out.println("◆ (Mother) Arrah Villa Calapre Walsh");      
                        System.out.println("◆ (Mom's Boyfriend) Michelle");
                        System.out.println("◆ (Little Sister) Zhiannelle Dampog Gravino");
                        System.out.println("◆ (Little Brother) Sean Carlisle Dampog Gravino");
                        System.out.println("◆ (Little Sister) Sophia Walsh");
                        System.out.println("◆ (Cousin) Carlo Calapre");
                        System.out.println("◆ (Uncle) Aaron Jevier Calapre Dampog");
                        System.out.println("◆ (Uncle) Jezyh Calapre Dampog");
                        System.out.println("◆ (Aunt) Phoebe Maghanoy Dampog");
                        System.out.println("==============================================");
                        break;
                    case 2:
                        System.out.println("\n================Best-Friends=================");
                        System.out.println("◆ Samsodhen Olay       ◆ Binudin Zaifullah   ");
                        System.out.println("◆ Pahad Baoc Radia     ◆ Gian Carlo Abreu    ");
                        System.out.println("◆ Joelle Jia Roa       ◆ Roneen Miano        ");
                        System.out.println("==============================================");
                        break;
                    
                    case 3:
                        System.out.println("\n=======================Friends=======================");
                        System.out.println("◆ Lehi Weed               ◆ Selwyn Kent Santiniaman  ");
                        System.out.println("◆ Keith Cliffe            ◆ Disangcopan Yanez Amerah ");
                        System.out.println("◆ Renuel Pagasian         ◆ Darrel James Oyoa        ");
                        System.out.println("◆ Hazim Dimacaling        ◆ John Mar Malangit Canada ");
                        System.out.println("◆ Cayden Austin           ◆ Althia Jane Tabay        ");
                        System.out.println("◆ Alexander Alawiya       ◆ Ahmad Benito Samsodin    ");
                        System.out.println("◆ Mia Garcia              ◆ Wayne Presidente         ");
                        System.out.println("◆ Abdul Razak Manua       ◆ Ruffa Mae Khu            ");
                        System.out.println("◆ Hemfa Benito            ◆ Yasin O NY               ");
                        System.out.println("◆ Keeshiaceres Millanar   ◆                          ");
                        System.out.println("======================================================");
                        break;

                    case 4:
                        System.out.println("\n==============Teachers/Professors==============");
                        System.out.println("◆ Professor Paige Labarr (CSC-115)");
                        System.out.println("◆ Professor Will Mclaughlin (CSC-103)");
                        System.out.println("◆ Professor Wendy Gray (CSC-142)");
                        System.out.println("◆ Soniely Rivera (Loo Brew Internship)");
                        System.out.println("◆ Ma'am Catherine Quiapo (Grade 11 Advisor)");
                        System.out.println("===============================================");
                        break;

                    case 5:
                        System.out.println("\nWIP");
                        break;

                    case 6:
                        System.out.println("\nWIP");
                        break;

                    case 7:
                        System.out.println("\n==============Neighbor==============");
                        System.out.println("◆ Professor Paige Labarr (CSC-115)");
                        System.out.println("◆ Professor Will Mclaughlin (CSC-103)");
                        System.out.println("◆ Professor Wendy Gray (CSC-142)");
                        System.out.println("◆ Soniely Rivera (Loo Brew Internship)");
                        System.out.println("◆ Ma'am Catherine Quiapo (Grade 11 Advisor)");
                        System.out.println("===============================================");
                        break;

                    case 8:
                        System.out.println("\n==========Crush==========");
                        System.out.println("1. Gwyneth Caballes Acad ");
                        System.out.println("2. Lady Jersey Alberina  ");
                        System.out.println("3. Savannah Fish         ");
                        System.out.println("=========================");
                        break;
                }
            break;

        }

        System.out.println("\nWould you like to know more? (Y/N)");
        char CASE1RETURN = scanner.next().charAt(0);

        if (CASE1RETURN == 'y' || CASE1RETURN == 'Y') {
            main(new String[0]);
            return;
        } else {
            System.out.println("\nThank you for your time!");
        }

        scanner.close();
    }
}
