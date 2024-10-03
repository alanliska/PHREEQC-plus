# PHREEQC-plus
PHREEQC + OpenMOPAC + CHEMSOL + XTB + DFTB+ + FastChem Cond and more

Description & Use:
PHREEQC (authors: David L. Parkhurst, C.A.J. Appelo) is a favourite geochemical code used for speciation modelling. Our application brings the users the experience of extending capabilities due to integration of MOPAC (author: James JP Stewart), CHEMSOL (authors: Jan Florián, Arieh Warshel), XTB (authors: C. Bannwarth, E. Caldeweyher, S. Ehlert, A. Hansen, P. Pracht, J. Seibert, S. Spicher, S. Grimme, P. Shushkov, M. Stahn, H. Neugebauer, J.-M. Mewes, V. Asgeirsson, C. Bauer, J. Koopman) and DFTB+ (authors: B. Hourahine, B. Aradi, V. Blum, F. Bonafé, A. Buccheri, C. Camacho, C. Cevallos, M. Y. Deshaye, T. Dumitrică, A. Dominguez, S. Ehlert, M. Elstner, T. van der Heide, J. Hermann, S. Irle, J. J. Kranz, C. Köhler, T. Kowalczyk, T. Kubař, I. S. Lee, V. Lutsker, R. J. Maurer, S. K. Min, I. Mitchell, C. Negre, T. A. Niehaus, A. M. N. Niklasson, A. J. Page, A. Pecchia, G. Penazzi, M. P. Persson, J. Řezáč, C. G. Sánchez, M. Sternberg, M. Stöhr, F. Stuckenberg, A. Tkatchenko, V. W.-z. Yu, T. Frauenheim). Any custom species not present in the built-in databases can be now calculated directly within the app and the results used in the model (in other words, a new, specific database can be constructed in each run separately). Furthermore, the current package contains numerous non-conventional databases utilizing both experimental as well as predicted / calculated data from big databases such as CHNOSZ, ModelSEED, Alexandria library, KEGG and other literal sources.
Except from the equilibrium state, the code supports also kinetics modelling, for which the respective keyword blocks can be generated automatically based on the previous transitional state computation. As an alternative for non-aqueous systems, FastChem Cond speciation modelling is available as well. 
All the programs features are available offline. 

Warning about the computational accuracy: MOPAC represents a reasonable compromis between power of the device/calculation time and prediction accuracy for large variety of compound types ranging from small to mid-sized molecules. However, the accuracy is limited. In order to tune the resulting energies, COSMO model from MOPAC as well as CHEMSOL solvation models are integrated, although CHEMSOL is originally intented to be used in connection with the structures and charges calculated at higher levels of theory. Therefore, all the calculated equilibrium and rate constants should be treated with caution and regarded as a rough estimate in cases when no experimental data (from the included databases) are available. XTB and DFTB+ integration is experimental so far. 

IMPORTANT !!!
Although this app is composed of open-source codes and resources, licenses for some components require the users to cite the original references when publishing the results. Please check all the licensing information under the buttons 'License' and 'About the app'.
All the users of the PHREEQC PLUS app comply by downloading, installing and using it with all the licensing conditions of the individual software components and take the responsibility for keeping them. 

The software has not received any approval by the U.S. Geological Survey (USGS). No warranty, expressed or implied, is made by the USGS or the U.S. Government as to the functionality of the software and related material nor shall the fact of release constitute any such warranty. The software is provided on the condition that neither the USGS nor the U.S. Government shall be held liable for any damages resulting from the authorized or unauthorized use of the software.

License: The PHREEQC plus app repository (except from the binary content in /app/src/main/jniLibs/) itself is covered by GPL3 license. However, the included third-party software as well as the corresponding documentation retains the original licenses - please see the individual entries below. 
App source code: https://github.com/alanliska/PHREEQC-plus

Contact:
Compilation of the source code for Android as well as the Android app development was done by Alan Liška (alan.liska@jh-inst.cas.cz) and Veronika Růžičková (sucha.ver@gmail.com), J. Heyrovský Institute of Physical Chemistry of the CAS, v.v.i., Dolejškova 3/2155, 182 23 Praha 8, Czech Republic.
Website: http://www.jh-inst.cas.cz/~liska/MobileChemistry.htm

List of used third-party software:
ACPDFVIEW, ANDROID SHELL, ARPACK, BLAS, CHEMSOL, CHIMESCALC, CPCM-X, CREST, DFTB+, DFTD4, EIGEN3, FASTCHEM Cond, GMP, GRAPHVIEW, LAPACK, LWONIOM, MBD, MCTC-LIB, MOPAC, MSTORE, MULTICHARGE, NUMSA, OPENBABEL, OPENBLAS, OPENMOPAC, OPSIN, PHREEQC, PLOTMS, PYTHON, QCXMS, S-DFTD3, STDA, TBLITE, TEST-DRIVE, TOML-F, TRANSPOSE, X11-BASIC, XTB, XTB4STDA.  

More info on licenses & references - please refer to the licensing information inside of the app.

==================================================================================================

Licenses and references to used third-party software:

 * ACPDFVIEW
 Author: Bhuvaneshw (Github)
 Source code: https://github.com/Bhuvaneshw/acpdfview
 License: GNU GPL-3.0

 * ANDROID SHELL
 Author: Jorrit "Chainfire" Jongma (JRummy Apps Inc.)
 Source code: https://github.com/aa668086/android-shell-master
 License: Apache License, Version 2.0

 * ARPACK
 Authors: D.C. Sorensen, R.B. Lehoucq, C. Yang, and K. Maschhoff; Allan Cornet, Sylvestre Ledru; Jordi Gutiérrez Hermoso; Sébastien Fabbro
 Source code: https://github.com/opencollab/arpack-ng
 License: BSD Software License

 * BLAS
 Source code: https://netlib.org/blas/
 License: freely-available software package

 * CHEMSOL
 Authors: Jan Florián, Arieh Warshel
 Ref.: Florián, J., and A. Warshel. "ChemSol, version 2.1." University of Southern California, Los Angeles (1999).
 Source code: https://github.com/jborden/ChemSol
 License: The Android binary distribution is published as freeware at Mobile Chemistry Portal and Google Play Store with kind permission of Jan Florián.

 * CHIMESCALC
 Authors: Rebecca K. Lindsey, Nir Goldman, Laurence E. Fried
 References: 
 -Carbon-1: R.K. Lindsey*, L.E. Fried, N. Goldman, J. Chem. Theory Comput., 13 6222 (2017).
 -PuH-DFTB: Goldman*, B. Aradi, R.K. Lindsey, L.E. Fried, J. Chem. Theory Comput. 14 2652 (2018).
 -Water-1: R.K. Lindsey*, L.E. Fried, N. Goldman, J. Chem. Theory Comput. 15 436 (2019).
 -CO-1: R.K. Lindsey*, N. Goldman, L.E. Fried, S. Bastea, J. Chem. Phys. 153 054103 (2020).
 -CO-2: R.K. Lindsey*, L.E. Fried, N. Goldman, S. Bastea, J. Chem. Phys. 153 134117 (2020).
 -COND-1: M.R. Armstrong*, R.K. Lindsey*, N. Goldman, M.H. Nielsen, E. Stavrou, L.E. Fried, J.M. Zaug, S. Bastea*, Nat, Commun. 11 353 (2020).
 -HN-1: Pham*, R.K. Lindsey, L.E. Fried, N. Goldman, J. Chem. Phys. 153 224102 (2020).
 -DNTF-DFTB: R.K. Lindsey*, S. Bastea*, N. Goldman, L. Fried, J. Chem. Phys. 154 164115 (2021).
 -TiH-DFTB: Goldman*, K. Kweon, R.K. Lindsey, L.E. Fried, T.W. Heo, B. Sadigh, P. Soderlind, A. Landa, A. Perron, J. Jeffries, B. Wood, J. Chem. Theory Comput. 17 4435 (2021).
 -QMD-DFTB: C.H. Pham*, R.K. Lindsey, L.E. Fried, N. Goldman, J. Phys. Chem. Lett. 13 2934 (2022).
 Source code: https://github.com/rk-lindsey/chimes_calculator
 License: LGPL-3.0

 * CPCM-X
 Authors/contributors: Marcel Stahn, Sebastian Ehlert, "Albkat" (GitHub)
 Ref.: M. Stahn, S. Ehlert, S. Grimme, J. Phys. Chem. A, 2023, XX, XXXX-XXXX. DOI: 10.1021/acs.jpca.3c04382
 Source code: https://github.com/grimme-lab/CPCM-X
 License: GNU GPL-3.0

 * CREST
 Authors: Philipp Pracht, Fabian Bohle, Stefan Grimme, C.A. Bauer, S. Spicher, C. Plett, A. Hansen, C. Bannwarth, S. Ehlert, G. Feldmann, J. Gorges
 Ref.: 
 -CREST: Pracht, P.; Bohle, F.; Grimme, S.; Automated exploration of the low-energy chemical space with fast quantum chemical methods, Phys. Chem. Chem. Phys., 2020, 22, 7169-7192. DOI: 10.1039/C9CP06869D
 -CREST 3.0: Pracht, P.; Grimme, S.; Bannwarth, C.; Bohle, F.; Ehlert, S.; Feldmann, G.; Gorges, J.; Müller, M.; Neudecker, T.; Plett, C.; Spicher, S.; Steinbach, P.; Wesołowski, P.A.; Zeller, F.; CREST — A program for the exploration of low-energy molecular chemical space, J. Chem. Phys., 2024, 160, 114110. DOI: 10.1063/5.0197592
 -Conformational Entropy: Pracht, P.; Grimme, S.; Calculation of absolute molecular entropies and heat capacities made simple, Chem. Sci., 2021, 12, 6551-6568. DOI: 10.1039/D1SC00621E
 -Meta-Dynamics Simulations: Grimme, S.; Exploration of Chemical Compound, Conformer, and Reaction Space with Meta-Dynamics Simulations Based on Tight-Binding Quantum Chemical Calculations, J. Chem. Theory Comput., 2019, 15 (5), 2847-2862. DOI: 10.1021/acs.jctc.9b00143
 -Protonation Site Determination: Pracht, P.; Bauer, C.; Grimme, S. Automated and efficient quantum chemical determination and energetic ranking of molecular protonation sites, J. Comput. Chem. 2017, 38 (30), 2618-2631. DOI: 10.1002/jcc.24922
 -Quantum Cluster Growth (QCG): Spicher, S.; Plett, C.; Pracht, P.; Hansen, A.; Grimme, S.; Automated Molecular Cluster Growing for Explicit Solvation by Efficient Force Field and Tight Binding Methods, J. Chem. Theory Comput., 2022, 18 (5), 3174-3189. DOI: 10.1021/acs.jctc.2c00239
 -Minimum Energy Crossing Point (MECP) sampling: Pracht, P.; Bannwarth, C.; Fast Screening of Minimum Energy Crossing Points with Semiempirical Tight-Binding Methods, J. Chem. Theory Comput., 2022, 18 (10), 6370-6385. DOI: 10.1021/acs.jctc.2c00578.
 -MC-ONIOMn: Wesołowski, P.A.; Wales, D.J.; Pracht, P.; Multilevel Framework for Analysis of Protein Folding Involving Disulfide Bond Formation, J. Phys. Chem. B, 2024, 128, 3145–3156. DOI: 10.1021/acs.jpcb.4c00104
 GFNn-xTB Methods
 -Review: Bannwarth, C.; Caldeweyher, E.; Ehlert, S.; Hansen, A.; Pracht, P.; Seibert, J.; Spicher, S.; Grimme, S.; WIREs Comput. Mol. Sci., 2020, 11, e01493. DOI: 10.1002/wcms.1493
 -GFN1-xTB: Grimme, S.; Bannwarth, C.; Shushkov, P.; A Robust and Accurate Tight-Binding Quantum Chemical Method for Structures, Vibrational Frequencies, and Noncovalent Interactions of Large Molecular Systems Parameterized for All spd-Block Elements (Z = 1-86). J. Chem. Theory Comput., 2017, 13 (5), 1989-2009. DOI: 10.1021/acs.jctc.7b00118
 -GFN2-xTB: Bannwarth, C.; Ehlert, S.; Grimme, S.; GFN2-xTB — An Accurate and Broadly Parametrized Self-Consistent Tight-Binding Quantum Chemical Method with Multipole Electrostatics and Density-Dependent Dispersion Contributions J. Chem. Theory Comput. 2019, 15 (3), 1652–1671. DOI: 10.1021/acs.jctc.8b01176 doi:10.1021/acs.jctc.2c00578
 -xTB-iFF: Grimme, S.; Bannwarth, C.; Caldeweyher, E.; Pisarek, J.; Hansen, A.; A general intermolecular force field based on tight-binding quantum chemical calculations, J. Chem. Phys., 2017, 147, 161708. DOI: 10.1063/1.4991798
 -GFN-FF: Spicher, S.; Grimme, S.; Robust atomistic modeling of materials, organometallic and biochemical systems Angew. Chem. Int. Ed. 2020, 59, 15665. DOI: 10.1002/anie.202004239
 Applications
 -Minimum Energy Crossing Points with GFN0-xTB: Pracht, P.; Bannwarth, C.; Finding Excited-State Minimum Energy Crossing Points on a Budget: Non-Self-Consistent Tight-Binding Methods, J. Phys. Chem. Lett., 2023, 14, 4440–4448, DOI: 10.1021/acs.jpclett.3c00494
 -Supramolecular Complexes containing Heavy Main Group Elements: Gorges, J.; Grimme, S.; Hansen, A.; Reliable prediction of association (free) energies of supramolecular complexes with heavy main group elements - the HS13L benchmark set, Phys. Chem. Chem. Phys., 2022, DOI 10.1039/D2CP04049B
 -Conformational Entropy in Solution: Gorges, J.; Grimme, S.; Hansen, A.; Pracht, P.; Towards understanding solvation effects on the conformational entropy of non-rigid molecules, Phys. Chem. Chem. Phys., 2022, 24, 12249-12259. DOI: 10.1039/D1CP05805C
 -Free Energy Calculations: Grimme, S.; Bohle, F.; Hansen, H.; Pracht, P.; Spicher, S.; Stahn, M.; Efficient Quantum Chemical Calculation of Structure Ensembles and Free Energies for Nonrigid Molecules, J. Phys. Chem. A, 2021, 125 (19), 4039-4054. DOI: 10.1021/acs.jpca.1c00971
 -Conformational Energies of Transition Metal Complexes (TMCONF40): Bursch, M.; Pracht, P.; Hansen, A.; Grimme, S. Theoretical study on conformational energies of transition metal complexes Phys. Chem. Chem. Phys. 2021, 23, 287-299. DOI: 10.1039/D0CP04696
 -Molecular Muscles: Kohn, J.; Spicher, S.; Bursch, M.; Grimme, S.; Quickstart guide to model structures and interactions of artificial molecular muscles with efficient computational methods, Chem. Commun., 2022, 58, 258-261. DOI: 10.1039/D1CC05759F
 -Small Molecule Binding in Metal Organic Polyhedra: Spicher, S.; Bursch, M.; Grimme, S. Efficient Calculation of Small Molecule Binding in Metal–Organic Frameworks and Porous Organic Cages J. Phys. Chem. C 2020, 124 (50), 27529-27541. DOI: 10.1021/acs.jpcc.0c08617
 -pKa Prediction (SAMPL6): Pracht, P.; Wilcken, R.; Udvarhelyi, A.; Rodde, S.; Grimme, S.; High accuracy quantum-chemistry-based calculation and blind prediction of macroscopic pKa values in the context of the SAMPL6 challenge., J. Comput.-Aided Mol. Des., 2018, 32, 1139-1149. DOI: 10.1007/s10822-018-0145-7
 -pKa Prediction: Pracht, P.; Grimme, S.; Efficient Quantum-Chemical Calculations of Acid Dissociation Constants from Free-Energy Relationships, J. Phys. Chem. A, 2021, 125 (25), 5681-5692. DOI: 10.1021/acs.jpca.1c03463
 -NMR Spectra Simulation: Grimme, S.; Bannwarth, C.; Dohm, S.; Hansen, A.; Pisarek, J.; Pracht, P.; Seibert, J.; Neese, F.; Fully Automated Quantum Chemistry Based Computation of Spin–Spin Coupled Nuclear Magnetic Resonance Spectra Angew. Chem. Int. Ed. 2017, 56 (20), 12485–12491. DOI: 10.1002/anie.201708266
 -NMR Spectra Simulation (Macrocycles): Bohle, F.; Grimme, S.; Hydrocarbon Macrocycle Conformer Ensembles and 13C-NMR Spectra, Angew. Chem. Int. Ed., 2022, 61, e202113905. DOI: 10.1002/anie.202113905
 -Optical Rotation Spectra Simulation: Bohle, F., Seibert, J.; Grimme, S.; Automated Quantum Chemistry-Based Calculation of Optical Rotation for Large Flexible Molecules, J. Org. Chem., 2021, 86 (21), 15522-15531. DOI: 10.1021/acs.joc.1c02008
 -IR Spectra Simulation: Pracht, P.; Grant, D.F.; Grimme, S.; Comprehensive Assessment of GFN Tight-Binding and Composite Density Functional Theory Methods for Calculating Gas-Phase Infrared Spectra, J. Chem. Theory Comput., 2020, 16 (11), 7044-7060. DOI: 10.1021/acs.jctc.0c00877
 Source code: https://github.com/crest-lab/crest
 License: LGPL-3.0, GPL-3.0

 * DFTB+
 Authors: B. Hourahine, B. Aradi, V. Blum, F. Bonafé, A. Buccheri, C. Camacho, C. Cevallos, M. Y. Deshaye, T. Dumitrică, A. Dominguez, S. Ehlert, M. Elstner, T. van der Heide, J. Hermann, S. Irle, J. J. Kranz, C. Köhler, T. Kowalczyk, T. Kubař, I. S. Lee, V. Lutsker, R. J. Maurer, S. K. Min, I. Mitchell, C. Negre, T. A. Niehaus, A. M. N. Niklasson, A. J. Page, A. Pecchia, G. Penazzi, M. P. Persson, J. Řezáč, C. G. Sánchez, M. Sternberg, M. Stöhr, F. Stuckenberg, A. Tkatchenko, V. W.-z. Yu, T. Frauenheim
 Ref.: DFTB+, a software package for efficient approximate density functional theory based atomistic simulations; J. Chem. Phys. 152, 124101 (2020).
 -DFTB+ code: B. Aradi, B. Hourahine, and Th. Frauenheim. DFTB+, a sparse matrix-based implementation of the DFTB method. J. Phys. Chem. A, 111(26):5678, 2007. 65, 131. 
 -non-SCC DFTB: D. Porezag, T. Frauenheim, T. Köhler, G. Seifert, and R. Kaschner. Construction of tightbinding-like potentials on the basis of density-functional theory: Application to carbon. Phys. Rev. B, 51:12947, 1995. 131.
                G. Seifert, D. Porezag, and T. Frauenheim. Calculations of molecules, clusters, and solids with a simplified LCAO-DFT-LDA scheme. Int. J. Quant. Chem., 58:185, 1996. 131. 
 -SCC DFTB: M. Elstner, D. Porezag, G. Jungnickel, J. Elsner, M. Haugk, T. Frauenheim, S. Suhai, and G. Seifert. Self-consistent-charge density-functional tight-binding method for simulations of complex materials properties. Phys. Rev. B, 58:7260, 1998. 54, 131. 
 -Collinear spin polarization: C. Köhler, G. Seifert, and T. Frauenheim. Density-functional based calculations for Fe(n),(n<=32). Chem. Phys., 309:23, 2005. 131. 
 -Non-collinear spin polarization, Spin orbit coupling: C. Köhler, T. Frauenheim, B. Hourahine, G. Seifert, and M. Sternberg. Treatment of collinear and noncollinear electron spin within an approximate density functional based method. J. Phys. Chem. A, 111(26):5622, 2007. 131.
 -QM/MM coupling (external charges): Q. Cui, M. Elstner, T. Frauenheim, E. Kaxiras, and M. Karplus. Combined self-consistent charge density functional tight-binding (SCC-DFTB) and CHARMM. J. Phys. Chem. B, 105:569, 2001. 131.
                                     W. Han, M. Elstner, K. J. Jalkanen, T. Frauenheim, and S. Suhai. Hybrid SCC-DFTB/molecular mechanical studies of H-bonded systems and of N-acetyl-(L-Ala)n-N’-Methylamide helices in water solution. Int. J. Quant. Chem., 78:459, 2000. 131. 
 -Van der Waals interaction (dispersion): M. Elstner, P. Hobza, T. Frauenheim, S. Suhai, and E. Kaxiras. Hydrogen bonding and stacking interactions of nucleic acid base pairs: a density-functional-theory based treatment. J. Chem. Phys., 114:5149, 2001. 45, 46, 47, 123, 131. 
 -DFTB+U: B. Hourahine, S. Sanna, B. Aradi, C. Köhler, T. Niehaus, and Th. Frauenheim. Self-interaction and strong correlation in DFTB. J. Phys. Chem. A, 111(26):5671, 2007. 42, 131. 
 -3rd order corrections: Y. Yang, H. Yu, D. York, Q. Cui, and M. Elstner. Extension of the self-consistent-charge density-functional tight-binding method: Third-order expansion of the density functional theory total energy and introduction of a modified effective coulomb interaction. J. Phys. Chem. A, 111:10861, 2007. 49, 50, 131. 
 -Linear response TD-DFTB: T. A. Niehaus, S. Suhai, F. Della Sala, P Lugli, M. Elstner, G. Seifert, and Th. Frauenheim. Tight-binding approach to time-dependent density-functional response theory. Phys. Rev. B, 63:085108, 2001. 59, 131. 
 Source code: https://github.com/dftbplus/dftbplus
 License: GNU Lesser General Public License v3
 Slater-Koster files: Creative Commons Attribution-ShareAlike 4.0 International license (for authors and references to individual sets, please see the License/LICENSING TERMS-SLATER-KOSTER-FILES, or check their homepage https://dftb.org/parameters/download/all-sk-files). For easier work in the mobile devices, all the Slater-Koster files are merged in one folder 'sk_files' and their type is distinguished in the name of the middle-separator, e.g. '-3ob-', '-mio-' etc. Please be aware that in any case of using the results for publication purposes, the authors and their works specified in the corresponding Slater-Koster file set have to be cited properly. The license permits use of their work only under the condition that their proper citing is enforced. 
 Recipes: This work is licensed under the Creative Commons Attribution-ShareAlike 4.0 International (CC BY-SA 4.0) To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/4.0/ or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.

 * DFTD4
 Authors: Eike Caldeweyher, Christoph Bannwarth, Stefan Grimme, Sebastian Ehlert, Andreas Hansen, Hagen Neugebauer, Sebastian Spicher, Jan-Michael Mewes
 Ref.: Eike Caldeweyher, Christoph Bannwarth and Stefan Grimme, J. Chem. Phys., 2017, 147, 034112. DOI: 10.1063/1.4993215
       Eike Caldeweyher, Sebastian Ehlert, Andreas Hansen, Hagen Neugebauer, Sebastian Spicher, Christoph Bannwarth and Stefan Grimme, J. Chem Phys, 2019, 150, 154122. DOI: 10.1063/1.5090222 chemrxiv: 10.26434/chemrxiv.7430216
       Eike Caldeweyher, Jan-Michael Mewes, Sebastian Ehlert and Stefan Grimme, Phys. Chem. Chem. Phys., 2020, 22, 8499-8512. DOI: 10.1039/D0CP00502A chemrxiv: 10.26434/chemrxiv.10299428
 Source code: https://github.com/dftd4/dftd4
 License: GNU GPL v3 and GNU LGPL v3

 * DOCS (CREST)
 Taken from: https://crest-lab.github.io/crest-docs/
 Source code: https://github.com/crest-lab/crest-docs
 License: Copyright © 2022-2024 Philipp Pracht. CREST is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

 * DOCS (XTB)
 Taken from: https://xtb-docs.readthedocs.io/en/latest/contents.html
 Source code: https://github.com/grimme-lab/xtb_docs
 License: This work is licensed under the Creative Commons Attribution-ShareAlike 4.0 International (CC BY-SA 4.0). To view a copy of this license, visit creative commons or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.

 * EIGEN3
 Authors: Benoît Jacob, Gaël Guennebaud and many others (please check the homepage https://eigen.tuxfamily.org/index.php?title=Main_Page)
 Source code: https://eigen.tuxfamily.org/index.php?title=Main_Page
 License: MPL2, earlier versions LGPL3+

 * FASTCHEM
 Authors: Daniel Kitzmann, Joachim Stock
 References: Stock, J. W., Kitzmann, D., Patzer, A. B. C., Sedlmayr, E.: FastChem: A computer program for efficient complex chemical equilibrium calculations in the neutral/ionized gas phase with applications to stellar and planetary atmospheres. Monthly Notices of the Royal Astronomical Society, 479(1) (2018) 865-874.
             Stock, J. W., Kitzmann, D., & Patzer, A. B. C.: FastChem 2: An improved computer program to determine the gas-phase chemical equilibrium composition for arbitrary element distributions. Monthly Notices of the Royal Astronomical Society, 517(3) (2022) 4070-4080.
             Kitzmann, D., Stock, J.W., Patzer, A.B.: FastChem Cond: Equilibrium chemistry with condensation and rainout for cool planetary and stellar environments. arXiv preprint arXiv:2309.02337. 2023 Sep 5.
 Source code: https://github.com/NewStrangeWorlds/FastChem
 License: This project is Copyright (c) Daniel Kitzmann and Joachim Stock. FastChem is released under the GNU Public Licence (GPL) 3.0. That means, it can be freely copied, edited, and re-distributed. If the code is re-distributed it has to be released under at least a GPL 3.0 licence as well. The full licence of FastChem can be found in the repository *licence.md* file or under https://www.gnu.org/licenses/gpl-3.0.html. The user guide is released under the Creative Commons Licence (CC BY SA). Licensees may copy and distribute the work and make derivative works based on it only if they give the authors (Daniel Kitzmann & Joachim Stock) the credits by providing a reference to the original guide and this GitHub repository. Licensees may also distribute derivative works only under a license identical to ("not more restrictive than") the license that governs the original work.

 * GBSA parameters
 Authors/contributors: please see XTB for authors and references
 Source code: https://github.com/grimme-lab/gbsa-parameters
 License: Attribution-ShareAlike 4.0 International

 * GMP
 Contributors: please see the page https://gmplib.org/manual/Contributors
 Source code: https://gmplib.org/
 License: GNU LGPL v3 and GNU GPL v2

 * GRAPHVIEW
 Author: Jonas Gehring
 Source code: https://github.com/jjoe64/GraphView
 License: Apache License, Version 2.0

 * LAPACK
 Source code: https://netlib.org/lapack/
 License: freely-available software package, modified BSD license

 * LWONIOM
 Authors: P. Wesołowski, D. J. Wales, P. Pracht
 Ref.: P. Wesołowski, D. J. Wales, and P. Pracht, “A multilevel framework for analysis of protein folding involving disulphide bond formation,” The Journal of Physical Chemistry B 128.13 (2024): 3145-3156. https://doi.org/10.1021/acs.jpcb.4c00104
 Source code: https://github.com/crest-lab/lwoniom
 License: LGPL-3.0, GPL-3.0

 * MBD
 Authors: J. Hermann, M. Stöhr, S. Góger, S. Chaudhuri, B. Aradi, R. J. Maurer, A. Tkatchenko
 Ref.: J. Hermann, M. Stöhr, S. Góger, S. Chaudhuri, B. Aradi, R. J. Maurer & A. Tkatchenko. J. Chem. Phys. 159, 174802 (2023). 
 Source code: https://github.com/libmbd/libmbd
 License: MPL-2.0

 * MCTC-LIB
 Authors/contributors: Sebastian Ehlert, Eisuke Kawashima, Marcel Stahn, Kjell Jorner and others (please see the source code page)
 Source code: https://github.com/grimme-lab/mctc-lib
 License: Apache v2

 * MOPAC
 Author: James JP Stewart
 Ref.: Stewart, James J.P., Journal of computer-aided molecular design 4(1) (1990) 1-103.
 Source code: http://openmopac.net/
 License: LGPL3 license, GPL3 license

 * MSTORE
 Authors/contributors: Sebastian Ehlert, Kjell Jorner, Eisuke Kawashima
 Source code: https://github.com/grimme-lab/mstore
 License: Apache v2

 * MULTICHARGE
 Authors/contributors: Sebastian Ehlert, Eisuke Kawashima, Daniel Mejia-Rodriguez, Kjell Jorner
 Source code: https://github.com/grimme-lab/multicharge
 License: Apache v2

 * NUMSA
 Authors/contributors: Marcel Stahn, Sebastian Ehlert
 References: Angular integration grids: V.I. Lebedev, and D.N. Laikov, A quadrature formula for the sphere of the 131st algebraic order of accuracy, Doklady Mathematics, Vol. 59, No. 3, 1999, pp. 477–481.
             Smooth numerical integration: W. Im, M.S. Lee, and C.L. Brooks III, Generalized Born model with a simple smoothing function, J. Comput. Chem., Vol. 24, No. 14, 2003, pp. 1691–1702.
             DFT-D3 van-der-Waals radii: S. Grimme, J. Antony, S. Ehrlich, and H. Krieg, A consistent and accurate ab initio parametrization of density functional dispersion correction (DFT-D) for the 94 elements H-Pu, J. Chem. Phys., Vol. 132, 2010, p. 154104.
             Bondi van-der-Waals radii: M. Mantina, A.C. Chamberlin, R. Valero, C.J. Cramer, and D.G. Truhlar, Consistent van der Waals Radii for the Whole Main Group, J. Phys. Chem. A, Vol. 113, No. 19, 2009, pp.. 5806–5812.
 Source code: https://github.com/grimme-lab/numsa
 License: LGPL3 license, GPL3 license

 * OPENBABEL
 Ref.: N M O'Boyle, M Banck, C A James, C Morley, T Vandermeersch, and G R Hutchison. "Open Babel: An open chemical toolbox." J. Cheminf. (2011), 3, 33. DOI:10.1186/1758-2946-3-33
 Source code: http://openbabel.org/wiki/Main_Page, https://github.com/openbabel/openbabel
 License: GPL-2.0

 * OPENBLAS
 Authors: Zhang Xianyi, Wang Qian, Zaheer Chothia
 Ref.: Xianyi, Z., Qian, W., & Chothia, Z. (2012). OpenBLAS. URL: http://xianyi. github. io/OpenBLAS, 88.
 Source code: https://github.com/xianyi/OpenBLAS
 License: BSD3-Clause

 * OPENMOPAC
 Ref.: see MOPAC
 Developers: Jonathan E. Moussa, Susi Lehtola, Sina Mostafanejad, Karl-Michael Schindler, Jan Rezac, Sebastian Ehlert
 License: LGPL-3.0, GPL-3.0

 * OPSIN
 Authors/developers: Rich Apodaca, Albina Asadulina, Peter Corbett, Daniel Lowe (Current maintainer), John Mayfield, Peter Murray-Rust, Noel O'Boyle, Mark Williamson
 Ref.: Lowe, Daniel M., Peter T. Corbett, Peter Murray-Rust, and Robert C. Glen. "Chemical name to structure: OPSIN, an open source solution." (2011): 739-753.
 Source code: https://github.com/dan2097/opsin
 License: MIT License

 * PHREEQC
 Authors: David L. Parkhurst, C.A.J. Appelo
 Ref.: Parkhurst, D.L., and Appelo, C.A.J., 2013, Description of input and examples for PHREEQC version 3—A computer program for speciation, batch-reaction, one-dimensional transport, and inverse geochemical calculations: U.S. Geological Survey Techniques and Methods, book 6, chap. A43, 497 p.
 Source code: https://wwwbrr.cr.usgs.gov/projects/GWC_coupled/phreeqc/
 Usage: Public Domain

 * PLOTMS
 Authors/contributors: Jeroen Koopman, Johannes Gorges, Sebastian Ehlert and others (please see the source code page)
 Source code: https://github.com/qcxms/PlotMS
 License: GNU GPL v3 and GNU LGPL v3

 * PYTHON
 Source code: https://www.python.org/downloads/source/
 License: PSF license agreement, check the homepage https://docs.python.org/3.7/license.html for details

 * QCXMS
 Authors/contributors: Jeroen Koopman, Sebastian Ehlert, Johannes Gorges
 Ref.: S. Grimme, Towards First Principles Calculation of Electron Impact Mass Spectra of Molecules. Angew. Chem. Int. Ed., 52, 6306-6312 DOI:10.1002/anie.201300158
 Source code: https://github.com/qcxms/QCxMS
 License: GNU GPL v3 and GNU LGPL v3

 * S-DFTD3
 Authors/contributors: Sebastian Ehlert, Robert Cohn, Eisuke Kawashima, Shirong Wang, Kjell Jorner and others (please see the source code page)
 Ref.: S. Grimme, J. Antony, S. Ehrlich and H. Krieg J. Chem. Phys, 132 (2010), 154104.
       S. Grimme, S. Ehrlich and L. Goerigk J. Comput. Chem, 32 (2011), 1456-1465.
 Source code: https://github.com/dftd3/simple-dftd3
 License: GNU GPL v3 and GNU LGPL v3

 * STDA
 Authors/contributors: Marc de Wergifosse, Shoubhik Maiti, Pierre Beaujean, Sebastian Ehlert and others (please see the source code page)
 Ref: S. Grimme, A simplified Tamm–Dancoff density functional approach for the electronic excitation spectra of very large molecules, J. Chem. Phys., 2013, 138, 244104. DOI: 10.1063/1.4811331
      C. Bannwarth, S. Grimme, A simplified time-dependent density functional theory approach for electronic ultraviolet and circular dichroism spectra of very large molecules, Comput. Theor. Chem., 2014, 1040 – 1041, 45 – 53. DOI: 10.1016/j.comptc.2014.02.023
      S. Grimme and C. Bannwarth, Ultra-fast computation of electronic spectra for large systems by tight-binding based simplified Tamm-Dancoff approximation (sTDA-xTB) J. Chem. Phys., 2016, 145, 054103. DOI: 10.1063/1.4959605
      M. de Wergifosse, C. Bannwarth, S. Grimme, A simplified spin-flip time-dependent density functional theory (SF-sTD-DFT) approach for the electronic excitation spectra of very large diradicals, J. Phys. Chem. A, 2019, 123 (27), 815–5825. DOI: 10.1021/acs.jpca.9b03176
      M. de Wergifosse, S. Grimme, Nonlinear-response properties in a simplified time-dependent density functional theory (sTD-DFT) framework: Evaluation of the first hyperpolarizability, J. Chem. Phys., 2018, 149 (2), 024108. DOI: 10.1063/1.5037665
      M. de Wergifosse, S. Grimme, Nonlinear-response properties in a simplified time-dependent density functional theory (sTD-DFT) framework: Evaluation of excited-state absorption spectra, J. Chem. Phys., 2019, 150, 094112. DOI: 10.1063/1.5080199
      M. de Wergifosse, J. Seibert, S. Grimme, Simplified time-dependent density functional theory (sTD-DFT) for molecular optical rotation, J. Chem. Phys., 2020, 153, 084116. DOI: 10.1063/5.0020543
      M. de Wergifosse, S. Grimme, A unified strategy for the chemically intuitive interpretation of molecular optical response properties, J. Chem. Theory Comput., 2020, 16 (12), 7709–7720. DOI: 10.1021/acs.jctc.0c00990
      M. de Wergifosse, P. Beaujean, S. Grimme, Ultrafast evaluation of two-photon absorption with simplified time-dependent density functional theory, J. Phys. Chem. A, 2022, XX, XXXX. DOI: 10.1021/acs.jpca.2c02395
 Source code: https://github.com/grimme-lab/stda
 License: GNU GPL v3 and GNU LGPL v3

 * TBLITE
 Authors/contributors: Sebastian Ehlert, Daniel Mejia-Rodriguez, Marvin Friede, Zeyuan Tang, Hagen Neugebauer, Konstantin Karandashev and others (please see the source code page)
 Source code: https://github.com/tblite/tblite
 License: GNU GPL v3 and GNU LGPL v3

 * TEST-DRIVE
 Authors/contributors: Sebastian Ehlert, Jeremie Vandenplas, Christopher Howard
 Source code: https://github.com/fortran-lang/test-drive
 License: Apache v2, MIT

 * TOML-F
 Authors/contributors: Sebastian Ehlert, Robert Cohn, Bálint Aradi, Asdrubal Lozada-Blanco, Rohit Goswami, Ben Hourahine, Emily Kahl, Daniel Mejia-Rodriguez, Kjell Jorner
 Source code: https://github.com/toml-f/toml-f
 License: Apache v2, MIT

 * TRANSPOSE
 Author: Dr. Alex Sheppard (alex@das-computer.co.uk)
 Source code: https://sourceforge.net/projects/transpose/
 License: This software is released under the GPL license (GNU General Public License version 2.0 (GPLv2)). 

 * X11-BASIC
 Author: Markus Hoffmann
 Source code: https://github.com/kollokollo/X11Basic
 License: GPL-2.0

 * XTB
 Authors: C. Bannwarth, E. Caldeweyher, S. Ehlert, A. Hansen, P. Pracht, J. Seibert, S. Spicher, S. Grimme, P. Shushkov, M. Stahn, H. Neugebauer, J.-M. Mewes, V. Asgeirsson, C. Bauer, J. Koopman
 Ref.: 
   -General References to xtb and the implemented GFN methods:
    C. Bannwarth, E. Caldeweyher, S. Ehlert, A. Hansen, P. Pracht, J. Seibert, S. Spicher, S. Grimme WIREs Comput. Mol. Sci., 2020, 11, e01493. DOI: 10.1002/wcms.1493
    M. de Wergifosse, P. Beaujean, S. Grimme, Ultrafast evaluation of two-photon absorption with simplified time-dependent density functional theory, J. Phys. Chem. A 2022, 126, 41, 7534–7547. DOI: 10.1021/acs.jpca.2c02395
   -for GFN-xTB:
    S. Grimme, C. Bannwarth, P. Shushkov, J. Chem. Theory Comput., 2017, 13, 1989-2009. DOI: 10.1021/acs.jctc.7b00118
    C. Bannwarth, S. Ehlert and S. Grimme., J. Chem. Theory Comput., 2019, 15, 1652-1671. DOI: 10.1021/acs.jctc.8b01176
    P. Pracht, E. Caldeweyher, S. Ehlert, S. Grimme, ChemRxiv, 2019, preprint. DOI: 10.26434/chemrxiv.8326202.v1
   -for GFN-FF:
    S. Spicher and S. Grimme, Angew. Chem. Int. Ed., 2020, 59, 15665–15673 DOI: 10.1002/anie.202004239
   -for GBSA and ALPB implicit solvation:
    S. Ehlert, M. Stahn, S. Spicher, S. Grimme, J. Chem. Theory Comput., 2021, 17, 4250-4261 DOI: 10.1021/acs.jctc.1c00471
   -for ddCOSMO and CPCM-X implicit solvation:
    M. Stahn, S. Ehlert, S. Grimme, J. Phys. Chem. A, 2023, XX, XXXX-XXXX. DOI: 10.1021/acs.jpca.3c04382
   -for DFT-D4:
    E. Caldeweyher, C. Bannwarth and S. Grimme, J. Chem. Phys., 2017, 147, 034112. DOI: 10.1063/1.4993215
    E. Caldeweyher, S. Ehlert, A. Hansen, H. Neugebauer, S. Spicher, C. Bannwarth and S. Grimme, J. Chem. Phys., 2019, 150, 154122. DOI: 10.1063/1.5090222
    E. Caldeweyher, J.-M. Mewes, S. Ehlert and S. Grimme, Phys. Chem. Chem. Phys., 2020, 22, 8499-8512. DOI: 10.1039/D0CP00502A
   -for sTDA-xTB:
    S. Grimme and C. Bannwarth, J. Chem. Phys., 2016, 145, 054103. DOI: 10.1063/1.4959605
   -in the mass-spec context:
    V. Asgeirsson, C. Bauer and S. Grimme, Chem. Sci., 2017, 8, 4879. DOI: 10.1039/c7sc00601b
    J. Koopman and S. Grimme, ACS Omega, 2019, 4, 12, 15120-15133. DOI: 10.1021/acsomega.9b02011
    J. Koopman and S. Grimme, J. Am. Soc. Mass Spectrom., 2021, 32, 7, 1735-1751. DOI: 10.1021/jasms.1c00098
   -for metadynamics refer to:
    S. Grimme, J. Chem. Theory Comput., 2019, 155, 2847-2862. DOI: 10.1021/acs.jctc.9b00143
   -for SPH calculations refer to:
    S. Spicher and S. Grimme, J. Chem. Theory Comput., 2021, 17, 1701–1714. DOI: 10.1021/acs.jctc.0c01306
   -for ONIOM refer to:
    C. Plett, A. Katbashev, S. Ehlert, S. Grimme, M. Bursch, Phys. Chem. Chem. Phys., 2023, 25, 17860-17868. DOI: 10.1039/D3CP02178E
   -for DIPRO refer to:
    J. Kohn, N. Gildemeister, S. Grimme, D. Fazzi, A. Hansen, J. Chem. Phys., 2023, just accepted.
   -for PTB refer to:
    S. Grimme, M. Mueller, A. Hansen, J. Chem. Phys., 2023, 158, 124111. DOI: 10.1063/5.0137838
   -with help from (in alphabetical order)
    P. Atkinson, C. Bannwarth, F. Bohle, G. Brandenburg, E. Caldeweyher,
    M. Checinski, S. Dohm, S. Ehlert, S. Ehrlich, I. Gerasimov, C. Hölzer,
    A. Katbashev, J. Kohn, J. Koopman, C. Lavigne, S. Lehtola, F. März, M. Müller,
    F. Musil, H. Neugebauer, J. Pisarek, C. Plett, P. Pracht, F. Pultar,
    J. Seibert, P. Shushkov, S. Spicher, M. Stahn, M. Steiner, T. Strunk,
    J. Stückrath, T. Rose, and J. Unsleber
 Source code: https://github.com/grimme-lab/xtb
 License: GNU GPL v3 and GNU LGPL v3

 * XTB4STDA
 Authors/contributors: Sebastian Ehlert, Pierre Beaujean, Shoubhik Maiti, Jonathon Vandezande
 Ref.: S. Grimme and C. Bannwarth, J. Chem. Phys., 2016, 145, 054103. DOI: 10.1063/1.4959605
 Source code: https://github.com/grimme-lab/xtb4stda
 License: GNU GPL v3 and GNU LGPL v3

Manuals:

 * PHREEQC 3 reference manual: https://github.com/usgs-coupled/phreeqc3/blob/master/doc/Phreeqc_3_2013_manual.pdf (public domain)

 * PHREEQC 2 equations: https://github.com/usgs-coupled/phreeqc3/blob/master/doc/Phreeqc_2_1999_manual.pdf (public domain)

 * PHREEQC isotopes: https://github.com/usgs-coupled/phreeqc3/blob/master/doc/wrir02-4172.pdf (public domain)

 * FastChem: https://github.com/exoclime/FastChem/blob/master/manual/fastchem_manual.pdf (GPL v3)

 * MOPAC: https://github.com/openmopac/openmopac.github.io/tree/main (BSD 3-Clause)

 * DFTB+: https://github.com/dftbplus/dftbplus/releases/download/23.1/manual.pdf (public domain)

 * DFTB+ recipes: https://dftbplus-recipes.readthedocs.io/en/latest/ (CC BY-SA 4.0)

 * MODES: https://dftbplus.org/fileadmin/DFTB-Plus/public/dftb/current/manual-modes.pdf (public domain)

 * XTB: https://xtb-docs.readthedocs.io/en/latest/ (CC BY-SA 4.0)

 * CREST: https://crest-lab.github.io/crest-docs/ (public domain)

 * STDA: https://www.chemiebn.uni-bonn.de/pctc/mulliken-center/software/stda/stda_manual.pdf (public domain)

 * OpenBABEL: https://buildmedia.readthedocs.org/media/pdf/open-babel/latest/open-babel.pdf (CC0)

 * Chemsol: https://github.com/jborden/ChemSol/blob/master/documentation/cs21_manual.pdf (public domain)

 * X11-BASIC: https://x11-basic.sourceforge.net/X11-Basic-manual.pdf (GNU Free Documentation License)

Sources of the pre-compiled binaries:

 * buildwire: https://github.com/alanliska/dftbplus-for-phreeqc-plus

 * crest: https://github.com/alanliska/crest-for-phreeqc-plus

 * dftb: https://github.com/alanliska/dftbplus-for-phreeqc-plus

 * fastchem: https://github.com/alanliska/FastChem-Cond-for-PHREEQC-plus

 * flux: https://github.com/alanliska/dftbplus-for-phreeqc-plus

 * chemsol: https://github.com/alanliska/CHEMSOL-for-phreeqc-plus

 * makecube: https://github.com/alanliska/dftbplus-for-phreeqc-plus

 * modes: https://github.com/alanliska/dftbplus-for-phreeqc-plus

 * mopac: https://github.com/alanliska/mopac-for-phreeqc-plus

 * mopac-makpol: https://github.com/alanliska/mopac-for-phreeqc-plus

 * mopac-param: https://github.com/alanliska/mopac-for-phreeqc-plus

 * obabel: https://github.com/alanliska/openbabel-for-phreeqc-plus

 * phonons: https://github.com/alanliska/dftbplus-for-phreeqc-plus

 * phreeqc: https://github.com/alanliska/phreeqc3-for-phreeqc-plus

 * plotms: https://github.com/alanliska/PlotMS-for-phreeqc-plus

 * qcxms: https://github.com/alanliska/QCxMS-for-phreeqc-plus

 * setupgeom: https://github.com/alanliska/dftbplus-for-phreeqc-plus

 * stda: https://github.com/alanliska/stda-for-phreeqc-plus

 * transpose: https://sourceforge.net/projects/transpose/

 * waveplot: https://github.com/alanliska/dftbplus-for-phreeqc-plus

 * xbbc: https://github.com/alanliska/X11-Basic-for-Android

 * xbvm: https://github.com/alanliska/X11-Basic-for-Android

 * xtb: https://github.com/alanliska/xtb-for-phreeqc-plus

 * xtb4stda: https://github.com/alanliska/xtb4stda-for-phreeqc-plus

Other references:

 * Alexandria library
 Ghahremanpour, M., van Maaren, P. & van der Spoel, D. The Alexandria library, a quantum-chemical database of molecular properties for force field development. Sci Data 5, 180062 (2018). https://doi.org/10.1038/sdata.2018.62

 * Analchem database
 Kotrlý, S., Šůcha, L., Chemické rovnováhy v analytické chemii: Tabulky a diagramy, SNTL 1988.
 next sources - in footnotes at the individual entries 

 * Basic series of PHREEQC databases
 Alberty R.A., Thermodynamics of Biochemical Reactions (1st ed.), John Wiley & Sons, Hoboken, New Jersey 2003.
 Alberty R.A., Biochemical Thermodynamics: Applications of Mathematica, John Wiley & Sons, Hoboken, New Jersey 2006.
 Bard, A. J., Parsons, R., Jordan, J. (editors), Standard potentials in aqueous solution, Marcel Dekker, New York 1985.
 Cabani, S., Gianni, P., Mollica, V., Lepori, L., Group contributions to the thermodynamic properties of non-ionic organic solutes in dilute aqueous solution, Journal of Solution Chemistry 10(8) (1981) 563-595.
 John, A.D., Lange’s handbook of chemistry (Fifthenth Edition), Mc. Graw Hill Inc, New York 1999.
 Dolfing J., Harrison B.K., Gibbs free-energy of formation of halogenated aromatic-compounds and their potential role as electron-acceptors in anaerobic environments, Environ Sci Technol 26 (1992) 2213-2218.
 Dolfing J., Janssen D.B., Estimates of Gibbs free energies of formation of chlorinated aliphatic compounds, Biodegradation, 5(1) (1994) 21-28.
 Mobley D.L., Guthrie J.P., FreeSolv: a database of experimental and calculated hydration free energies, with input files, J Comput Aided Mol Des. 28(7) (2014) 711-20.
 Loach P.A., Handbook of Biochemistry and Molecular Biology: Oxidation-Reduction Potentials, Absorbance Bands and Molar Absorbance of Compounds used in Biochemical Studies (4th ed.) CRC Press 2010, pp. 557-562.
 Wiesinger, H., Hinz, H.J., Thermodynamic data for protein-ligand interaction. In Thermodynamic data for biochemistry and biotechnology, Springer, Berlin, Heidelberg 1986, pp. 211-226.
 Jankowski, M. D., Henry, C. S., Broadbelt, L. J., Hatzimanikatis, V., Group contribution method for thermodynamic analysis of complex metabolic networks, Biophysical journal, 95(3) (2008) 1487-1499.
 Mavrovouniotis M.L., Group contributions for estimating standard Gibbs energies of formation of biochemical-compounds in aqueous-solution, Biotechnology and Bioengineering 36 (1990) 1070-1082.
 Joback, K. G., Reid, R. C., Estimation of pure-component properties from group-contributions, Chemical Engineering Communications, 57(1-6) (1987) 233-243.
 Kanehisa, M., The KEGG database. In Novartis foundation symposium, John Wiley, Chichester, New York 1999, pp. 91-100.
 Klopman, G., Wang, S., Balthasar, D.M., Estimation of aqueous solubility of organic molecules by the group contribution approach. Application to the study of biodegradation, Journal of chemical information and computer sciences, 32(5) (1992) 474-482.
 Martell A.E., Smith R.M., Motekaitis R.J., NIST Critically Selected Stability Constants of Metal Complexes Database, 8.0. NIST: Gaithersburg, MD, 2004.
 Plyasunova N.V., Plyasunov A.V., Shock E.L., Database of thermodynamic properties for aqueous organic compounds, Intern. J. Thermophys., 25 (2004) 351-360.
 Sedlbauer, J., Ehlerova, J., Slavik, M., Establishing recommended data on thermodynamic properties of hydration for selected organic solutes and gases, http://artec.tul.cz/files/results/2011-Establishing-TPH%20data.pdf. 
 Thauer R.K., Jungermann K., Decker K., Energy conservation in chemotrophic anaerobic bacteria, Bacteriological reviews, 41(3) (1977) 809.
 Atkins, P., Atkins, P.W., de Paula, J., Atkins' physical chemistry, Oxford university press 2014.
 Van Krevelen, D.W., Te Nijenhuis, K., Properties of polymers: their correlation with chemical structure; their numerical estimation and prediction from additive group contributions, Elsevier, Amsterdam, Oxford 2009.
 Wagman D., Evans W., Parker V., Schumm R., Halow I., Bailey S., Churney K., Nuttall R., The NBS Tables of Chemical Thermodynamic Properties, J. Phys. Chem. Ref. Data 11, (Supplement No. 2).

 * Blank databases (Database_anhydr, Database_water)
 Bard, A. J., Parsons, R., Jordan, J. (editors), Standard potentials in aqueous solution, Marcel Dekker, New York 1985.
 Florián, J., Warshel, A., ChemSol, version 2.1, University of Southern California, Los Angeles (1999).

 * Datasets I series, CHNOSZ+ModelSEED database
 Dick, J. M., CHNOSZ: Thermodynamic calculations and diagrams for geochemistry, Frontiers in Earth Science, 7 (2019) 180.
 Henry, C.S., DeJongh, M., Best, A.B., Frybarger, P.M., Linsay, B., R.L. Stevens, High-throughput Generation and Optimization of Genome-scale Metabolic Models, Nature Biotechnology (2010).

 * Datasets II series
 Binnewies, M., Milke, E., Thermochemical data of elements and compounds (Vol. 168), Wiley-VCH, Weinheim 2002.

 * MOPAC resources: manuals and reference data dowloaded from the OPENMOPAC Github page (https://github.com/openmopac/mopac-archive).

 * OPENBABEL resources: parameter and other files taken from the official distribution site (http://openbabel.org/wiki/Main_Page, https://github.com/openbabel/openbabel, https://sourceforge.net/projects/openbabel/).

 * PHREEQC databases distributed within the official installers - please see https://water.usgs.gov/water-resources/software/PHREEQC/index.html. 

 * PHREEQC derived ("_anhydr" and "_w") databases utilizing the elemental species for connection with MOPAC/CHEMSOL estimated equilibria
 Florián, J., and A. Warshel. "ChemSol, version 2.1." University of Southern California, Los Angeles (1999).
 Bard, A. J., Parsons, R., Jordan, J. (editors), Standard potentials in aqueous solution, Marcel Dekker, New York 1985.
 Dick, J. M., CHNOSZ: Thermodynamic calculations and diagrams for geochemistry, Frontiers in Earth Science, 7 (2019) 180.
 Kobayashi, K., Suzuki T.S, Electron Comm Jpn. 2019;102:12–16.
 Shkol’nikov, E.V., Russian Journal of Physical Chemistry A 90(3) 2016.

 * pKa datasheet contains values taken from NIST database (Martell A.E., Smith R.M., Motekaitis R.J., NIST Critically Selected Stability Constants of Metal Complexes Database, 8.0. NIST: Gaithersburg, MD, 2004.).

 * Thermoddem database - downloaded from https://thermoddem.brgm.fr/databases/phreeqc.

 * UV-Vis spectra convolution: Tirri, Bernardino. Détermination d’un protocole de calcul pour la prédiction de spectres UV-vis de molécules en solution. Diss. Université Paris sciences et lettres, 2022.

Literature used in empirical estimations of equilibrium data
 Glasser, L., Jenkins, H.D.B., Standard absolute entropies, S 298, from volume or density: Part II. Organic liquids and solids, Thermochimica acta 414(2) (2004) 125-130.
 Hoshino, D., Nagahama, K., Hirata, M., Prediction of the entropy of vaporization at the normal boiling point by the group contribution method, Industrial & engineering chemistry fundamentals, 22(4) (1983) 430-433.
 Jankowski, M. D., Henry, C. S., Broadbelt, L. J., Hatzimanikatis, V., Group contribution method for thermodynamic analysis of complex metabolic networks, Biophysical journal, 95(3) (2008) 1487-1499.
 Joback, K. G., Reid, R. C., Estimation of pure-component properties from group-contributions, Chemical Engineering Communications, 57(1-6) (1987) 233-243.
 Van Krevelen, D.W., Te Nijenhuis, K., Properties of polymers: their correlation with chemical structure; their numerical estimation and prediction from additive group contributions, Elsevier, Amsterdam, Oxford 2009.
 Vohlídal, J., Julák, A., Štulík, K., Chemické a analytické tabulky, Grada Publishing, Praha 1999.

Literature used in empirical estimations of kinetics data
 Bodek, I., Lyman, W.J., Reehl, W.F., Rosenblatt D.H. (Eds.): Environmental Inorganic Chemistry. Properties, Processes, and Estimation Methods. Pergamon Press, New York, Oxford, Beijing, Frankfurt, Sao Paulo, Sydney, Tokyo, Toronto 1988.
 Eigen, M., Z. Phys. Chem. 1 (1954) 176-200.
 Eigen, M., Z. Electrochem. 64 (1960) 115-130.
 Fuoss, R.M., J. Am. Chem. Soc. 80(19) (1958) 5059-5061.
 Wilkins, R.G.: Kinetics and Mechanism of Reactions of Transition Metal Complexes, 2nd Edition. Wiley-VCH, Weinheim 2002.
 Zhou, G.Q., Zhong, W.Z., Eur. J. Biochem. 128 (1982) 383.

Literature used in proton and electron references
 Bartmess, J.E., Thermodynamics of the electron and the proton, The Journal of Physical Chemistry 98(25) (1994) 6420-6424.
 Fifen, J.J.,Thermodynamics of the electron revisited and generalized, Journal of Chemical Theory and Computation 9(7) (2013) 3165-3169.
 Isse, A.A., Gennaro, A., Absolute potential of the standard hydrogen electrode and the problem of interconversion of potentials in different solvents, The Journal of Physical Chemistry B 114(23) (2010) 7894-7899.
 Llano, J., Eriksson, L.A., First principles electrochemistry: Electrons and protons reacting as independent ions, The Journal of chemical physics 117(22) (2002) 10193-10206.

Literature and other sources of data in inorganic and organic kinetics datasheets
 Astin, A. V. Tables of Chemical Kinetics, Homogeneous Reactions, Suplement 1, National Bureau of Standards Circular 510; U.S. Government Printing Office: 1953.
 Astin, A. V. Tables of Chemical Kinetics, Homogeneous Reactions, Supplementary Tables, National Bureau of Standards Monograph 34; U.S. Government Printing Office: 1961.
 Astin, A. V. Tables of Chemical Kinetics, Homogeneous Reactions, Supplementary Tables; National Bureau of Standards Monograph 34 - vol. 2, U.S. Government Printing Office: 1964.
 Bamford, C. H.; Tipper, C. F. H. (Eds.) Comprehensive Chemical Kinetics, Decomposition of Inorganic and Organometallic Compounds, vol. 4; Elsevier Publishing Company: Amsterdam, London, New York, 1972.
 Bamford, C. H.; Tipper, C. F. H. (Eds.) Comprehensive Chemical Kinetics, Decomposition and Isomerization of Organic Compounds, vol.5.; Elsevier Publishing Company: Amsterdam, London, New York, 1972.
 Bamford, C. H.; Tipper, C. F. H. (Eds.) Comprehensive Chemical Kinetics, Reactions of Non-metallic Inorganic Compounds, vol. 6; Elsevier Publishing Company: Amsterdam, London, New York, 1972.
 Bamford, C.H.; Tipper, C.F.H. Comperhensive Chemical Kinetics, Vol.7 (Reactions of Metallic Salts and Complexes, and Organometallic Compounds.; Elsevier Publishing Company: Amsterdam, London, New York, 1972.
 Bamford, C. H.; Tipper, C. F. H. (Eds.) Comprehensive Chemical Kinetics, Addition and Elimination Reactions of Aliphatic Compounds, vol. 9; Elsevier Publishing Company: Amsterdam, London, New York, 1973.
 Bamford, C. H.; Tipper, C. F. H. (Eds.) Comprehensive Chemical Kinetics, Ester Formation and Hydrolysis and Related Reactions, vol. 10; Elsevier Publishing Company: Amsterdam, London, New York, 1972.
 Bamford, C. H.; Tipper, C. F. H. (Eds.) Comprehensive Chemical Kinetics, Electrophlic substitution at a saturated carbon atom, vol.12.; Elsevier Publishing Company: Amsterdam, London, New York, 1973.
 Bamford, C. H.; Tipper, C. F. H. (Eds.) Comprehensive Chemical Kinetics, Reactions of Aromatic Compounds, vol. 13; Elsevier Publishing Company: Amsterdam, London, New York, 1972.
 Bamford, C. H.; Tipper, C. F. H. (Eds.) Comprehensive Chemical Kinetics, Liquid Phase Oxidation, vol.16; Elsevier Publishing Company: Amsterdam, Oxford, New York, 1980.
 Bamford, C. H.; Tipper, C. F. H. (Eds.) Comprehensive Chemical Kinetics, Selected Elementary Reactions, vol. 18; Elsevier Publishing Company: Amsterdam, Oxford, New York, 1976.
 Bamford, C. H.; Tipper, C. F. H. (Eds.) Comprehensive Chemical Kinetics, Reactions in the Solid State, vol. 22; Elsevier Publishing Company: Amsterdam, Oxford, New York, 1980.
 Basolo, F.; Pearson, R. G. Mechanisms of Inorganic Reactions, A Study of Metal Complexes in Solution; John Wiley & Sons, Inc.: New York, 1958.
 Benson, D. Mechanisms of inorganic reactions in solution, An Introduction.; McGraw-Hill: London, 1968.
 Burgess, J.; Hague, D. N.; Kemmitt, R.D.W. Inorganic Reaction Mechanisms, vol.1.; The Chemical Society: Burlington House, London, 1971.
 Burgess, J.; Hague, D. N.; Kemmitt, R. D. W.; McAuley, A. Inorganic Reaction Mechanisms, vol.2.; The Chemical Society: Burlington House, London, 1972.
 Burgess, J.; Hague, D. N.; Kemmitt, R. D. W.; McAuley, A.; Smith, M. A. R. Inorganic Reaction Mechanisms, vol.3.; The Chemical Society: Burlington House, London, 1974.
 Condon, E. U. Tables of Chemical Kinetics, Homogeneous Reactions, Circular of the National Bureau of Standards 510; U.S. Government Printing Office: 1951.
 Edwards, J.O. Inorganic Reaction Mechanisms, Part II.; Interscience Publishers: New York, London, Sydney, Toronto, 1972.
 Kleinberg, J. Mechanisms of Inorganic Reactions, Advances in Chemistry Series 49. American Chemical Society, University of Kansas: Lawrence, 1964.
 Mark, H. B.; Rechnitz, G. A. Kinetics in Analytical Chemistry.; Interscience Publishers: New York, London, Sydney, 1968.
 McAuley, A.; Burgess, J.; Coe, J. S.; Hague, D. N.; Kemmitt, R. D. W.;  Moore, P.; Scott, K. L.; Smith, M. A. R.; Stedman, G. Inorganic Reaction Mechanisms, vol.4.; The Chemical Society: Burlington House, London, 1976.
 McAuley, A.; Burgess, J.; Cannon, R. D.; Davidson, J. L.; Hague, D. N.; Lappin, A. G.; Moore, P.; Stedman, G. Inorganic Reaction Mechanisms, vol.5.; The Chemical Society: Burlington House, London, 1977.
 McAuley, A.; Burgess, J.; Cannon, R. D.; Davidson, J. L.; Hague, D. N.; Lappin, A. G.; Lindsell, W. E.;  Moore, P.; Stedman, G. Inorganic Reaction Mechanisms, vol.6.; The Chemical Society: Burlington House, London, 1981.
 NDRL/NIST Solution Kinetics Database on the Web (NIST Standard Reference Database 40), 2002, https://kinetics.nist.gov/solution/(accessed Mar 2018).
 Palm, V. A. Tables of Rate and Equilibrium Constants of Heterolytic Organic Reactions, Vol.4.; Moscow, 1977.
 Palm, V. A. Tables of Rate and Equilibrium Constants of Heterolytic Organic Reactions, Vol.5.; Moscow, 1978.
 Palm, V. A. Tables of Rate and Equilibrium Constants of Heterolytic Organic Reactions, Vol.5(II).; Moscow, 1979.
 Sykes, A. G. Kinetics of Inorganic Reactions.; Pergamon Press: Oxford, London, Edinburgh, New York, Toronto, Sydney, Paris, Braunschweig, 1970.
 Sykes, A. G.; Burgess, J.; Buxton, G. V.;  Cannon, R. D.; Deeming, A. J.; Elding, L. I.; Lappin, A. G.; McAuley, A.; Moore, P.; Stedman, G. Inorganic Reaction Mechanisms, vol.7.; The Chemical Society: Burlington House, London, 1979.
 van Eldik, R.; Hubbard, C. D. Advances in Inorganic Chemistry, vol. 54; Academic Press: Erlangen-Nürnberg, 2003.
 Washburn, E. W. International Critical Tables of Numerical Data, Physics, Chemistry and Technology, 1 Electronic Ed.; Knovel: 2003. Online version available at https://app.knovel.com/hotlink/toc/id:kpICTNDPC4/international-critical/international-critical
 Ahlstrom, C., Boyd, W.B., Epstein, I.R., Kustin, K., Romanow, J.H., Inorg. Chem. 23 (1984) 2185.
 Alamgir, M., Epstein, I.R., J. Am. Chem. Soc. 105 (1983) 2500.
 Alamgir, M., Epstein, I.R., J. Phys. Chem. 89 (1985) 3611.
 Alamgir, M., De Kepper, P., Orbán, M., Epstein, I.R., J. Am. Chem. Soc. 105 (1983) 2641.
 Alamgir, M., Epstein, I.R., J. Phys. Chem. 88 (1984) 2848.
 Alamgir, M., Orbán, M., Epstein, I.R., J. Phys. Chem. 87 (1983) 3725.
 Alowitz, M. J., Scherer, M.M., Environmental science & technology 36(3) (2002) 299.
 Appelman, E.H., Kläning, U.K., Thompson, R.C., J. Am. Chem. Soc. 101(4) (1979) 929.
 Babatunde, O.A., World Journal of Chemistry 3(1) (2008) 27.
 Bakač, A., Orhanovic, M., Inorganica Chimica Acta 21 (1977) 173.
 Barr, S.W., Guyer, K.L., Weaver, M.J., J. Electroanal. Chem. 111 (1980) 41.
 de Barros Faria, R., Epstein, I.R., Kustin, K., J. Am. Chem. Soc. 114 (1992) 7164.
 de Barros Faria, R., Epstein, I.R., Kustin, K., J. Phys. Chem. 96(17) (1992) 6861.
 de Barros Faria, R., Lengyel, I., Epstein, I.R., Kustin, K., J. Phys. Chem. 97 (1993) 1164.
 Benko, J., Vollárová, O., Burgess, J., López, P., Transition Metal Chemistry 25 (2000) 674.
 Bhattacharyya, P.K., Saini, R.D., Ruikar, P.B., International Journal of Chemical Kinetics 13(4) (1981) 385.
 Bingham, D., Burnett, M.G., Journal of the Chemical Society A: Inorganic, Physical, Theoretical (1970) 2165.
 Chiang, Y.S., Craddock, J., Mickewich, D., Turkevich, J., J. Phys. Chem. 70(11) (1966) 3509.
 Chimatadar, S.A., Koujalagi, S.B., Nandibewoor, S.T., Transition Metal Chemistry 27 (2002) 704.
 Citri, O., Epstein, I.R., J. Phys. Chem. 92 (1988) 1865.
 Citri, O., Epstein, I.R., J. Am. Chem. Soc. 108(3) (1986) 357.
 Citri, O., Epstein, I.R., J. Phys. Chem. 91 (1987) 6034.
 Crouse, W.C., Margerum, D.W., Inorganic Chemistry 13(6) (1974) 1437.
 Cornelius, R.D., Gordon, G., Inorg. Chem. 15(5) (1976) 1002.
 Dasgupta, M., Mahanti, M.K., Bull. Chem. Soc. Jpn. 61 (1988) 4133.
 Dateo, C.E., Orbán, M., De Kepper, P., Epstein, I.R., J. Am. Chem. Soc. 104 (1982) 504.
 De Kepper, P., Epstein, I.R., Kustin, K., Orbán, M., J. Phys. Chem. 86 (1982) 170.
 Deshwal, B.R., Lee, H.-K., Journal of Hazardous Materials B108 (2004) 173.
 Doona, C.J., Kustin, K., Orbán, M., Epstein, I.R., J. Am. Chem. Soc. 113 (1991) 7484.
 Doremus, R.H., Murphy, D., Bansal, N.P., Lanford, W.A., Burman, C., Journal of materials science 20 (1985) 4445.
 Dózsa, L., Beck, M.T., Inorganica Chimica Acta 4 (1970) 219.
 Dózsa, L., Szilassy, I., Beck. M.T., Inorganica Chimica Acta 23 (1977) 29.
 D'Ulivo, A., Onor, M., Spiniello, R., Pitzalis, E., Spectrochimica Acta Part B 63 (2008) 835.
 Edblom, E.C., Luo, Y., Orbán, M., Kustin, K., Epstein, I.R., J. Phys. Chem. 93 (1989) 2722.
 Edblom, E.C., Györgyi, L., Orbán, M., Epstein, I.R., J. Am. Chem. Soc. 109 (1987) 4876.
 Epstein, I.R., Kustin, K., Simoyi, R.H., J. Am. Chem. Soc. 104 (1982) 712.
 Epstein, I.R., Kustin, K., J. Phys. Chem. 89 (1985) 2275.
 Epstein, I.R., Kustin, K., J. Phys. Chem. 96 (1992) 5852.
 Epstein, I.R., Kustin, K., Simoyi, R.H., J. Phys. Chem. 96 (1992) 6326.
 Espenson, J.H., Helzer, S.R., Inorg. Chem. 8(5) (1969) 1051.
 Fowless, A.D., Stranks, D.R., Inorganic Chemistry 16(6) (1977) 1282.
 Furman, C.S., Margerum, D.W., Inorg. Chem. 37 (1998) 4321.
 Galwey, A.K., Mansour, S.A.A., Thermochimica Acta 228 (1993) 379.
 Gerritsen, C.M., Margerum, D.W., Inorg. Chem. 29 (1990) 2757.
 Gordon, G., Tachlyashiki, S., Environ. Sci. Technol. 25 (1991) 468.
 Grant, J.L., De Kepper, P., Epstein, I.R., Kustin, K., Orbán, M., Inorg. Chem. 21 (1982) 2192.
 Gupta, Y.K., Bhargava, A.P., Bulletin of the Chemical Society of Japan 38(1) (1965) 12.
 Gupta, K.S., Bhargava, P., Manoj, S.V., Transition Metal Chemistry 25 (2000) 274.
 Hicks, K.W., Sutter, J.R., J. Phys. Chem. 75(8) (1971) 1107.
 Horváth, A.K., J. Phys. Chem. A 111 (2007) 890.
 Iadevia, R., Earley, J.E., Inorganica Chimica Acta 53 (1981) L143.
 Irving, H., Nature 173 (1954) 670.
 Jacobsen, F., Holcman, J., Sehested, K., International journal of chemical kinetics 30(3) (1998) 207.
 Jia-Zhong, Z., Whitfield, M., Marine Chemistry 19 (1986) 121.
 Jordan, A.D., Scott, S.L., Jordan, R.B., Inorganica Chimica Acta 239 (1995) 99.
 Karavanova, Y.A., Stenina, I.A., Yaroslavtsev, A.B., Russian Journal of Inorganic Chemistry 54(7) (2009) 995.
 Kerezsi, I., Lente, G., Fábián, I., Dalton Trans. (2004) 342.
 Kimmel, H.S., Cusumano, J.P., Lambert, D.G., Journal of solid state chemistry 12 (1975) 110.
 Kirschenbaum, L.J., Sutter, J.R., J. Phys. Chem. 70(12) (1966) 3863.
 Kjaer, A.M., Ulstrup, J., Inorg. Chem. 21 (1982) 3490.
 Kovacs, K., Leda, M., Vanag, V.K., Epstein, I.R., Physica D 239 (2010) 757.
 Lawani, S.A., J. Phys. Chem. 80(2) (1976) 105.
 Lawani, S.A., Sutter, J.R., J. Phys. Chem. 77(12) (1973) 1547.
 Legrand, L., El Figuigui, A., Mercier, F., Chausse, A., Environ. Sci. Technol. 38 (2004) 4587.
 Lengyel, I., Li, J., Epstein, I.R., J. Phys. Chem. 96 (1992) 7032.
 Lengyel, I., Rábai, G., Epstein, I.R., J. Am. Chem. Soc. 112 (1990) 4606.
 Lente, G., Kalmár, J., Baranyai, Z., Kun, A., Kék, I., Bajusz, D., Takács, M., Veres, L., Fábán, I., Inorg. Chem. 48 (2009) 1763.
 Levanov, A.V., Kuskov, I.V., Antipenko, E.E., Lunin, V.V., Russian Journal of Physical Chemistry 80(5) (2006) 726.
 Lister, M.W., Yoshino, Y., Can. J. Chem. 39 (1961) 96.
 Lister, M.W., Yoshino, Y., Can. J. Chem. 38 (1960) 2342.
 Liu, K.J., Lester, H., Peterson, N.C., Inorg. Chem. 5(12) (1966) 2129.
 Luna, R.M., Lapidus, G.T., Hydrometallurgy 56 (2000) 171.
 Luo, Y., Epstein, I.R., J. AM. Chem. Soc. 113 (1991) 1518.
 Luo, Y., Kustin, K., Epstein, I.R., Inorg. Chem. 27 (1988) 2489.
 Maruthamuthu, P., Neta, P., J. Phys. Chem. 82(6) (1978) 710.
 Maselko, J., Epstein, I.R., J. Phys. Chem. 88 (1984) 5305.
 Melicherčík, M., Olexová, A., Treindl, Ľ., Journal of Molecular Catalysis A: Chemical 127 (1997) 43.
 Melitas, N., Farrell, J., Environ. Sci. Technol. 36 (2002) 5476.
 Mihai, D., Rustoiu-Csavdari, A., Baldea, I., Anal Bioanal Chem 381 (2005) 1362.
 Milenkovic, M.C., Stanisavljev, D.R., Russian Journal of Physical Chemistry A 85(13) (2011) 2279.
 Morita, M., Iwamoto, K., Seno, M., Bull. Chem. Soc. Jpn. 61 (1988) 3467.
 Orbán, M., De Kepper, P., Epstein, I.R., J. Am. Chem. Soc. 104 (1982) 2657.
 Orbán, M., Dateo, C., De Kepper, P., Epstein, I.R., J. Am. Chem. Soc. 104 (1982) 5911.
 Orbán, M., Epstein, I.R., J. Phys. Chem. 86 (1982) 3907.
 Orbán, M., Epstein, I.R., J. Phys. Chem. 87 (1983) 3212.
 Orbán, M., Epstein, I.R., J. Am. Chem. Soc. 109 (1987) 101.
 Orbán, M., Epstein, I.R., J. Am. Chem. Soc. 111 (1989) 2891.
 Orbán, M., Epstein, I.R., J. Am. Chem. Soc. 104 (1982) 5918.
 Orbán, M., De Kepper, P., Epstein, I.R., J. Phys. Chem. 86(4) (1982) 431.
 Orbán, M., Lengyel, I., Epstein, I.R., J. Am. Chem. Soc. 113 (1991) 1978.
 Orbán, M., Epstein, I.R., J. Am. Chem. Soc. 111 (1989) 8543.
 Orbán, M., Epstein, I.R., J. Am. Chem. Soc. 112 (1990) 1812.
 Orbán, M., Epstein, I.R., J. Am. Chem. Soc. 107 (1985) 2302.
 Peintler, G., Nagypál, I., Epstein, I.R., J. Phys. Chem. 94 (1990) 2954.
 Petre, C.F., Larachi, F., Topics in Catalysis 37(2-4) (2006) 97.
 Quagraine, E.K., Georgakaki, I., Coucouvanis, D., Journal of Inorganic Biochemistry 103 (2009) 143.
 Rábai, G., Epstein, I.R., Inorg. Chem. 28 (1989) 732.
 Rábai, G., Orbán, M., Epstein, I.R., Acc. Chem. Res. 23 (1990) 258.
 Rábai, G., Kustin, K., Epstein, I.R., J. Am. Chem. Soc. 111 (1989) 8271.
 Rábai, G., Kustin, K., Epstein, I.R., J. Am. Chem. Soc. 111 (1989) 3870.
 Rábai, G., Orbán, M., Epstein, I.R., J. Phys. Chem. 96 (1992) 5414.
 Rábai, G., Hanazaki, I., J. Phys. Chem. 98 (1994) 2592.
 Rábai, G., Epstein, I.R., J. Phys. Chem. 94 (1990) 6361.
 Rábai, G., Epstein, I.R., J. Am. Chem. Soc. 114 (1992) 1529.
 Rábai, G., Epstein, I.R., Inorg. Chem. 31 (1992) 3239.
 Rawoof, M.A., Sutter, J.R., J. Phys. Chem. 71(9) (1967) 2767.
 Rechnitz, G.A., Rao, G.N., Analytical Chemistry 39(10) (1967) 1192.
 Reckley, J.S., Showalter, K., J. Am. Chem. Soc. 103 (1981) 7012.
 Sant, B. R., Naturwissenschaften 44(6) (1957) 180.
 Schmitz, G., International Journal of Chemical Kinetics 40(10) (2008) 647.
 Schmitz, G., International journal of chemical kinetics 36(9) (2004) 480.
 Sharma, P., Jordan, R.B., Inorg. Chem. 29 (1990) 1286.
 Sharma, K., Mehrotra, R.N. (2000).
 Sieklueka, B., Samotus, A., Transition Met. Chem. 21 (1996) 226.
 Sigsworth, S.W., Castleman, A.W., J. Am. Chem. Soc. 114 (1992) 10471.
 Simoyi, R.H., Epstein, I.R., J. Phys. Chem. 91 (1987) 5124.
 Simoyi, R.H., Epstein, I.R., Kustin, K., J. Phys. Chem. 93 (1989) 2792.
 Simoyi, R.H., Epstein, I.R., Kustin, K., J. Phys. Chem. 93 (1989) 1689.
 Simoyi, R.H., Manyonda, M., Masere, J., Mtambo, M., Ncube, I., Patel, H., Epstein, I.R., Kustin, K., J. Phys, Chem. 95 (1991) 770.
 Sorum, C.H., Charlton, F.S., Neptune, J.A., Edwards, J.O., Journal of the American Chemical Society 74(1) (1952) 219.
 Sturzbecher-Höhne, M., Nauser, T., Kissner, R., Koppenol, W.H., Inorg. Chem. 48 (2009) 7307.
 Szirovicza, L., Boga, E., International journal of chemical kinetics 30(12) (1998) 869.
 Szirovicza, L., React. Kinet. Catal. Lett. 96(2) (2009) 311.
 Takenaka, N., Furuya, S., Sato, K., Bandow, H., Maeda, Y., Furukawa, Y., International journal of chemical kinetics 35(5) (2003) 198.
 Valdes-Aguilera, Boyd, D.W., Epstein, I.R., Kustin, K., J. Phys. Chem. 90 (1986) 6696.
 Valdes-Aguilera, Boyd, D.W., Epstein, I.R., Kustin, K., J. Phys. Chem. 90 (1986) 6702.
 Voslař, M., Matějka, P., Schreiber, I., Inorg. Chem. 45 (2006) 2824.
 Wander, M.C.F., Kerisit, S., Rosso, K.M., Schoonen, M.A.A., J. Phys. Chem. A 110 (2006) 9691.
 Wang, F.T., Jolly, W.L., Inorg. Chem. 11(8) (1972) 1933.
 Westley, F.: Table of Recommended Rate Constants for Chemical Reactions Occuring in Combustion. NBS, Washington 1980.
 Yngli, A., Yunfeng, B., Qingyu, G., Chinese Science Bulletin 50(16) (2005) 1688.
 Yoshida, T., Ushiki, Y., Bull. Chem. Soc. Jpn. 55 (1982) 1772.
 Neta, P., Grodkowski J., Ross, A.B., Journal of Physical and Chemical Reference Data 25 (1996) 709.
 Buxton, G.P., Mulazzani, Q.G., Ross, A.B., Journal of Physical and Chemical Reference Data 24 (1995) 1055.
 Wilkinson, F., Helman, W.P., Ross, A.B., Journal of Physical and Chemical Reference Data 24 (1995) 113.
 Wilkinson, F., Helman, W.P., Ross, A.B., Journal of Physical and Chmeical Reference Data 22 (1993) 113.
 Neta, P., Huie, R.E., Ross, A.B., Journal of Physical and Chemical Reference Data 19 (1990) 413.
 Wardman, P., Journal of Physical and Chemical Reference Data 18 (1989) 1637.
 Hoffman, M.Z., Bolletta, F., Moggi, L.., Hug, G.L., Journal of Physical and Chemical Reference Data 18 (1989) 219.
 Neta, P., Huie, R.E., Ross, A.B., Journal of Physical and Chemical Reference Data 17 (1988) 1027.
 Buxton, G.V., Greenstock, C.L., Helman, W.P., Ross, A.B., Journal of Physical and Chemical Reference Data 17 (1988) 513.
 Carmichael, I., Hug, G.L., Journal of Physical and Chemical Reference Data 15 (1986) 1.
 Gordon, S., Sullivan, J.C., Ross, A.B., Journal of Physical and Chemical Reference Data 15 (1986) 1357.
 Bielski, B.H.J., Cabelli, D.E., Arudi, R.L., Ross, A.B., Journal of Physical and Chemical Reference Data 14 (1985) 1041.
 Denisov, E.T., transl. by Johnston, R.K.: Liquid-Phase Reaction Rate Constants. IFI/Plenum Data Company, New York - Washington - London 1974.
 Denisov, E.: Handbook of Antioxidants. CRC Press, Boca Raton, London, New York 2018.

Info on licenses: please see the full-text licenses under the button Licenses. 

ACKNOWLEDGEMENTS: 

Special thanks to Alice Jarošíková and Vojtěch Ettler (Charles University in Prague, Faculty of Science, Institute of geochemistry, mineralogy and mineral resources). 

The authors appreciate the financial support from the GACR projects 18-12150S, 19-22806S, 21-23261S, 23-06465S, and internal (institutional) support RVO: 61388955. 
