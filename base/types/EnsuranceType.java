package base.types;

public enum EnsuranceType {
  BASIC(0.10f),
  PREMIUM(0.25f);

  final float taxValue;

  EnsuranceType(float value){
    this.taxValue = value;
  }
}
