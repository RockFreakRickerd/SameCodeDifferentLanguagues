import Vak, math


class Student():
    # Constructor waar je naam nummer geslacht klas en studie in moet vullen bij aanmaken
    def __init__(self, nummer, naam, geslacht, klas, studie):
        self.vakken = []
        self.vakkenA = {}
        self.studentNR = nummer
        self.naam = naam
        self.geslacht = geslacht
        self.klas = klas
        self.studieRichting = studie

    # Getters (bij mij hier returns) om data te verkrijgen
    def returnNaam(self):
        return self.naam

    def returnGeslacht(self):
        return self.geslacht

    def returnStudentenNR(self):
        return self.studentNR

    def returnVakken(self):
        return self.vakken

    def returnVak(self, vak):
        for i in self.vakken:
            if i.getModuleCode() == vak:
                return i
        return 0

    def getCijfers(self, vak):
        for i in self.vakken:
            if i.getModuleCode() in vak:
                return i.getCijfers()

    # Nieuwe vak toevoegen of cijfer
    def newVak(self, vak, jaarGegeven):
        vakGG = Vak.Vak(vak, jaarGegeven)
        self.vakken.append(vakGG)

    def addCijfer(self, moduleCode, cijfer):
        for x in self.vakken:
            if x.getModuleCode() in moduleCode:
                x.setCijfers(cijfer)
                break

    # Print info van student specifiek of van alle vakken die student volgt
    def printVakkenInfo(self):
        for x in self.vakken:
            x.printInfo()

    def printInfo(self):
        print(
            self.naam + " met studentNummer " + self.studentNR + " is een " + self.geslacht + " en volgt " + self.studieRichting)

    #Deviatie van alle cijfers van alle vakken van student
    def deviatie(self):
        print("\nStandaardDeviatie van " + self.studentNR + ":")
        gemiddelde = []
        deviatie = 0.0
        average = 0
        for x in self.vakken:
            tijdelijk = x.getCijfers()
            for i in tijdelijk:
                gemiddelde.append(i)

        if not gemiddelde:
            print("No records")
            return 0.0

        for i in gemiddelde:
            average += i
        average /= len(gemiddelde)

        for i in range(0, len(gemiddelde)):
            newNumber = gemiddelde.pop(i) - average
            gemiddelde.insert(i, newNumber)
            newNumber = gemiddelde.__getitem__(i) * gemiddelde.__getitem__(i)
            gemiddelde.pop(i)
            gemiddelde.insert(i, newNumber)
            deviatie += gemiddelde.__getitem__(i)

        deviatie /= len(gemiddelde)
        deviatie = math.sqrt(deviatie)
        return deviatie
