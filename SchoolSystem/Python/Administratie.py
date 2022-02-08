import Color


class Administratie:
    # Bij aanmaken van administratie wordt er een list/Array aangemaakt waar de studenten in worden opgeslagen
    def __init__(self):
        self.students = []
        self.color = Color.bcolor()

    # Studenten aan students List/Array toevoegen
    def addStudents(self, student):
        self.students.append(student)

    # Alle builtinPoints van de opdracht
    def gemiddelde(self, student, vak):
        if student.returnVak(vak) == 0:
            return 0.0
        cijfers = student.returnVak(vak).getCijfers()
        if not cijfers:
            return 0.0
        average = 0
        for i in cijfers:
            average += i
        return average / len(cijfers)

    def battleOfTheSexte(self, vak):
        print("\nMannen vs Vrouwen voor vak " + vak + ":")
        gemiddeldeMannen = []
        gemiddeldeVrouwen = []
        gemM = 0.0
        gemV = 0.0
        for i in self.students:
            # if i.returnVak(vak) != 0:
            if i.returnGeslacht() == "M":
                gemiddeldeMannen.append(self.gemiddelde(i, vak))
            elif i.returnGeslacht() == "V":
                gemiddeldeVrouwen.append(self.gemiddelde(i, vak))
        if gemiddeldeMannen:
            for i in gemiddeldeMannen:
                gemM += i
            gemM /= len(gemiddeldeMannen)
        if gemiddeldeVrouwen:
            for i in gemiddeldeVrouwen:
                gemV += i
            gemV /= len(gemiddeldeVrouwen)
        if gemM > gemV:
            print("Mannen hebben beter gescoord dan vrouwen")
        elif gemM == gemV:
            print("Mannen hebben net zo hoog gescoord als vrouwen")
        else:
            print("Mannen hebben slechter gescoord dan vrouwen")

        print("gemiddelde van alle mannen: " + str(round(gemM, 2)))
        print("gemiddelde van all vrouwen: " + str(round(gemV, 2)))

    # Get cijfer van bepaalde vak van bepaalde student
    def getCijfer(self, student, vak):
        if student.returnVak(vak) == 0:
            return 0.0
        else:
            return student.returnVak(vak).getCijfers()

    # Cijfer toevoegen van student voor specifieke vak
    def newCijfer(self, student, vak, cijfer):
        vakStudent = student.returnVak(vak)
        studentenNR = student.returnStudentenNR()
        print("\nGrade is put in.....")
        if 0.0 <= cijfer < 10.0:
            if student.returnVak(vak) == 0:
                print("Student " + studentenNR + " is not following " + vak + " at this point")
            else:
                vakStudent.setCijfers(cijfer)
                print(
                    "Grade " + str(cijfer) + " has put in correctly for student " + studentenNR + " in subject " + vak)
        else:
            print("Grade is not correct between 0.0 and 10.0")

    # Vakken toevoegen aan student met string van naam en een jaartal
    # 1 vak toevoegen
    def newVak(self, student, newVak, jaar):
        student.newVak(newVak, jaar)

    # meerdere vakken per keer toevoegen gebruikt newVak van hierboven
    def setVakken(self, stud, vak1, vak2, vak3, vak4, jaar1, jaar2, jaar3, jaar4):
        self.newVak(stud, vak1, jaar1)
        self.newVak(stud, vak2, jaar2)
        self.newVak(stud, vak3, jaar3)
        self.newVak(stud, vak4, jaar4)

    # Behaald of onbehaald (als je behaald doet ziet hij beide hetzelfde als in java checken kan hier niet)
    def behaaldS(self, student):
        vakkenVanStudent = student.returnVakken()
        print("\nVakken die student " + student.returnNaam() + " heeft behaald.")
        for vak in vakkenVanStudent:
            if self.gemiddelde(student, vak.getModuleCode()) >= 6.0:
                print(vak.getModuleCode())

    def behaaldV(self, vak):
        print("\nStudenten die deze vak behaald hebben " + vak + ":")
        for stud in self.students:
            if self.gemiddelde(stud, vak) >= 6.0:
                print(stud.returnNaam())

    def onbehaaldS(self, student):
        vakkenVanStudent = student.returnVakken()
        print("\nVakken die student " + student.returnNaam() + " niet heeft behaald.")
        for vak in vakkenVanStudent:
            if self.gemiddelde(student, vak.getModuleCode()) < 6.0:
                print(vak.getModuleCode())

    def onbehaaldV(self, vak):
        print("\nStudenten die deze vak niet behaald hebben " + vak + ":")
        for stud in self.students:
            if self.gemiddelde(stud, vak) < 6.0:
                print(stud.returnNaam())

    # Print alle builtinPoints
    def printVariantie(self, vak):
        print("\nVariantie van " + vak + ": ")
        gemiddeldes = []
        variantie = 0.0
        average = 0.0
        for i in self.students:
            if i.returnVak(vak) != 0:
                outputList = i.returnVak(vak).getCijfers()
                for j in outputList:
                    gemiddeldes.append(j)
        if not gemiddeldes:
            print(self.color.fail+"No Records found"+self.color.endc)
            return

        for i in gemiddeldes:
            average += i
        average /= len(gemiddeldes)

        for i in range(0, len(gemiddeldes)):
            newNumber = gemiddeldes.__getitem__(i) - average
            gemiddeldes.pop(i)
            gemiddeldes.insert(i, newNumber)

            newNumber = gemiddeldes.__getitem__(i) * gemiddeldes.__getitem__(i)
            gemiddeldes.pop(i)
            gemiddeldes.insert(i, newNumber)
            variantie += gemiddeldes.__getitem__(i)

        variantie /= len(gemiddeldes)
        print("Variantie is: " + str(variantie))

    def printAlleCijfers(self, student):
        vakkenVanStudent = student.returnVakken()
        for vak in vakkenVanStudent:
            cijfers = self.getCijfer(student, vak)
            print("\nCijfers van student " + student.returnNaam() + " voor vak " + vak.getModuleCode() + ":")
            if not cijfers:
                print("No records")
                return
            else:
                for i in cijfers:
                    print(i)

    def printVakken(self, student):
        vakkenVanStudent = student.returnVakken()
        print("\n Vakken die student " + student.returnNaam() + "volgt:")
        for vak in vakkenVanStudent:
            print(vak.getModuleCode())

    def printDeviatie(self, student):
        deviatie = student.deviatie()
        print("Deviatie van " + student.returnNaam() + " is " + str(round(deviatie, 2)))

    def printStudents(self, vak):
        print("\nStudenen die deze " + vak + "volgen")
        for stud in self.students:
            if stud.returnVak(vak) != 0:
                print(stud.returnNaam())

    def printCijfers(self, student, vak):
        print("\nAlle cijfers van " + student.returnNaam() + " voor vak " + vak + ": ")
        cijfers = self.getCijfer(student, vak)
        if student.returnVak(vak) == 0:
            print("No records found")
            return
        vakS = student.returnVak(vak).getModuleCode()
        if cijfers == 0:
            print("No Grades")
        else:
            for cijfer in cijfers:
                print(cijfer)
