export const Metric = ({ label, value, change, icon: Icon, tone }: any) => {
  return (
    <div className="metric">
      <div className={`metric-icon ${tone}`}>
        <Icon />
      </div>
      <div>
        <p>{label}</p>
        <strong>{value}</strong>
        <small>
          <span className="up">{change}</span> vs last month
        </small>
      </div>
    </div>
  );
}