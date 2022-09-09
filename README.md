# PHREEQC-plus
PHREEQC + MOPAC + CHEMSOL and more

Description & Use:
PHREEQC is a favourite geochemical code used for speciation modelling. Our application brings the users the experience of extending capabilities due to integration of MOPAC and CHEMSOL. Any custom species not present in the built-in databases can be now calculated directly within the app and the results used in the model (in other words, a new, specific database can be constructed in each run separately). Furthermore, the current package contains numerous non-conventional databases utilizing both experimental as well as predicted / calculated data from big databases such as CHNOSZ, ModelSEED, Alexandria library, KEGG and other literal sources.
Except from the equilibrium state, the code supports also kinetics modelling, for which the respective keyword blocks can be generated automatically based on the previous transitional state computation. 
All the programs features are available offline. If the generated datasets operations are intended, it is highly recommended to grant access to manage all files manually (from Settings in Android device). Otherwise only files created by the app are readable for later use. 

Warning about the computational accuracy: MOPAC represents a reasonable compromis between power of the device/calculation time and prediction accuracy for large variety of compound types ranging from small to mid-sized molecules. However, the accuracy is limited. In order to tune the resulting energies, COSMO model from MOPAC as well as CHEMSOL solvation models are integrated, although CHEMSOL is originally intented to be used in connection with the structures and charges calculated at higher levels of theory. Therefore, all the calculated equilibrium and rate constants should be treated with caution and regarded as a rough estimate in cases when no experimental data (from the included databases) are available. 

Quick start: please check the included manuals and examples in Documets/phreeqc_plus folder.

Program status:
The current package contains PHREEQC, MOPAC 2016, CHEMSOL, OPENBABEL and X11-BASIC binaries compiled for the particular Android hardware platforms and adapted for running in generic, stock devices. The app requires permission to access the file-storage. It works completely offline and does not contain ads. The app does not collect any kind of personal information.

License: GNU Lesser General Public License v3.0
App source code: https://github.com/alanliska/PHREEQC-plus

Contact:
Compilation of the source code for Android as well as the Android app development was done by Alan Liška (alan.liska@jh-inst.cas.cz) and Veronika Růžičková (sucha.ver@gmail.com), J. Heyrovský Institute of Physical Chemistry of the CAS, v.v.i., Dolejškova 3/2155, 182 23 Praha 8, Czech Republic.
Website: http://www.jh-inst.cas.cz/~liska/MobileChemistry.htm

List of used third-party software:
BLAS, CHEMSOL (Florián, J., Warshel. A., Borden, J.), GMP,  LAPACK, MOPAC (Stewart, J.J.P.), OPENBABEL (O'Boyle, N.M., Banck, M., James, C.A., Morley, C., Vandermeersch, T., Hutchison, G.R.), OPENMOPAC (Jonathan E. Moussa, Susi Lehtola, Sina Mostafanejad, Karl-Michael Schindler, Jan Rezac, Sebastian Ehlert), PHREEQC (Parkhurst, D.L., Appelo, C.A.J.), X11-BASIC (Markus Hoffmann).

More info on licenses & references - please see the Documents/phreeqc_plus folder and the list under About button.
